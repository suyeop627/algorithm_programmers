import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();

        List<Task> tasks = Arrays.stream(plans)
                .map(p -> new Task(p[0], p[1], p[2]))
                .sorted()
                .collect(Collectors.toList());

        ArrayDeque<Task> stoppedTasks = new ArrayDeque<>();
        //다음 과제가 존재할 경우에만 시간 비교를 하기 위해서 size -1
        for (int i = 0; i < tasks.size() - 1; i++) {

            Task nowTask = tasks.get(i);
            LocalTime nextStart = tasks.get(i + 1).start;
            //현재 과제 시작시간부터 다음과제 시작시간까지의 여유시간
            int nowAvailableTime = (int) Duration.between(nowTask.start, nextStart).toMinutes();

            //다음과제 시작 전까지 현재 과제를 완료할 수 있는 경우
            if (nowTask.remainingMinute <= nowAvailableTime) {

                result.add(nowTask.name);
                int freeTime = nowAvailableTime - nowTask.remainingMinute;
                //다음과제 시작시간 전까지 미뤄둔 과제 있으면 처리 
                while (!stoppedTasks.isEmpty() && freeTime > 0) {
                    Task stoppedTask = stoppedTasks.pop();

                    if (stoppedTask.remainingMinute <= freeTime) { //잔여시간동안 과제를 완료할 수 있는 경우
                        result.add(stoppedTask.name);
                        freeTime -= stoppedTask.remainingMinute;
                    } else {//잔여시간 동안 미뤄둔 과제를 완료하지 못할경우 과제의 잔여시간만 차감
                        stoppedTask.doTaskDuring(freeTime);
                        stoppedTasks.push(stoppedTask);
                        freeTime = 0;
                    }
                }
            } else {
                //할수있는 만큼 과제 진행 후 미뤄두기
                nowTask.doTaskDuring(nowAvailableTime);
                stoppedTasks.push(nowTask);
            }

        }
        //마지막과제는 완료
        result.add(tasks.get(tasks.size()-1).name);
        //미뤄둔 과제 하나씩 처리
        while (!stoppedTasks.isEmpty()) {
            result.add(stoppedTasks.pop().name);
        }

        return result.toArray(new String[0]);//result.toArray(new String[result.size()]);
    }

    class Task implements Comparable<Task> {
        String name;
        LocalTime start;
        int remainingMinute;

        public Task(String name, String start, String playTime) {
            this.name = name;
            this.start = LocalTime.parse(start, dateTimeFormatter);
            this.remainingMinute = Integer.parseInt(playTime);
        }

        public void doTaskDuring(int time){
            remainingMinute -= time;
        }

        @Override
        public int compareTo(Task task) {
            return start.compareTo(task.start);
        }
    }
}