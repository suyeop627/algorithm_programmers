import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Job> queue = new LinkedList<>();
        for(int i = 0; i< progresses.length; i++){
            queue.offer(new Job(progresses[i], speeds[i]));
        }
        int day = 0;

        while(!queue.isEmpty()){
            day++;
            int deployCount = 0;

            while(!queue.isEmpty() && queue.peek().progress + queue.peek().speed * day >= 100){
                queue.poll();
                deployCount++;
            }

            if(deployCount > 0){
                list.add(deployCount);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Job{
        int progress;
        int speed;
        public Job(int p, int s){
            progress = p;
            speed = s;
        }
    }
}