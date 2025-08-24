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

        for (int i = 0; i < tasks.size() - 1; i++) {

            Task nowTask = tasks.get(i);
            LocalTime nextStart = tasks.get(i + 1).start;

            int nowAvailableTime = (int) Duration.between(nowTask.start, nextStart).toMinutes();

            if (nowTask.remainingMinute <= nowAvailableTime) {

                result.add(nowTask.name);
                int freeTime = nowAvailableTime - nowTask.remainingMinute;

                while (!stoppedTasks.isEmpty() && freeTime > 0) {
                    Task stoppedTask = stoppedTasks.pop();

                    if (stoppedTask.remainingMinute <= freeTime) {
                        result.add(stoppedTask.name);
                        freeTime -= stoppedTask.remainingMinute;
                    } else {
                        stoppedTask.doTaskDuring(freeTime);
                        stoppedTasks.push(stoppedTask);
                        freeTime = 0;
                    }
                }
            } else {
                nowTask.doTaskDuring(nowAvailableTime);
                stoppedTasks.push(nowTask);
            }

        }
        result.add(tasks.get(tasks.size()-1).name);

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