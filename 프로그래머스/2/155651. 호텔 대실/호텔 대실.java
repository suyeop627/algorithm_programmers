import java.time.LocalTime;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Booking> bookings = new ArrayList<>();

        for (String[] bookTime : book_time) {
            bookings.add(new Booking(bookTime[0], bookTime[1]));
        }

        bookings.sort(Comparator.comparing(b -> b.startTime));

        //우선순위가 높은 요소가 먼저 나가는 큐
        // - 우선순위 : compareTo 혹은 Comparator로 정해지는 정렬 순서에서 더 앞서는 객체
        //PriorityQueue<LocalTime> roomCleaningEndTimes = new PriorityQueue<>(LocalTime::compareTo);
        PriorityQueue<LocalTime> roomCleaningEndTimes = new PriorityQueue<>();

        int maxRooms = 0;

        for (Booking booking : bookings) {
            removeRoomsReady(booking, roomCleaningEndTimes);

            LocalTime roomCleaningEndtime = getRoomCleaningEndtime(booking);
            roomCleaningEndTimes.add(roomCleaningEndtime);

            maxRooms = Math.max(maxRooms, roomCleaningEndTimes.size());
        }

        return maxRooms;
    }

    private void removeRoomsReady(Booking booking, PriorityQueue<LocalTime> roomCleaningEndTimes) {
        //10분 퇴실 + 청소 10분 | 20분 입실 - 가능해야함
        while (!roomCleaningEndTimes.isEmpty() && !roomCleaningEndTimes.peek().isAfter(booking.startTime)) {
            roomCleaningEndTimes.poll();
        }
    }

    private LocalTime getRoomCleaningEndtime(Booking booking) {
        LocalTime bookingEndTime = booking.endTime;
        //예약 종료시간 + 청소시간이 자정 넘어가서 실패함 -> 자정 직전으로 지정
        if (!bookingEndTime.isBefore(LocalTime.of(23, 50))) {
            return LocalTime.of(23, 59);
        }

        return bookingEndTime.plusMinutes(10);
    }

    static class Booking {
        LocalTime startTime;
        LocalTime endTime;

        public Booking(String startTime, String endTime) {
            this.startTime = convertStringToLocalTime(startTime);
            this.endTime = convertStringToLocalTime(endTime);
        }

        private static LocalTime convertStringToLocalTime(String stringTime) {
            String[] hourAndMinute = stringTime.split(":");
            return LocalTime.of(Integer.parseInt(hourAndMinute[0]), Integer.parseInt(hourAndMinute[1]));
        }
    }
}