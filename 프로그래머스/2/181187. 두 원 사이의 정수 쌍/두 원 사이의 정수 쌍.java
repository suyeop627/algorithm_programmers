class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            //int로 downcasting 시 소수점 버림(floor)
            int maxY = (int) Math.sqrt((long) r2 * r2 - (long) x * x);
            //minY보다는 커야되므로 올림 처리
            int minY = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));
            answer += (maxY - minY + 1);
        }
        return answer * 4;
    }
}