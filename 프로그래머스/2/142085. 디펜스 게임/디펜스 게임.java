import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int e : enemy) {
            if (n  >= e) {
                priorityQueue.add(e);
                n -= e;
                answer++;
            } else if (k > 0) {
                if (!priorityQueue.isEmpty() && priorityQueue.peek() > e) {
                    Integer prevMaxEnemy = priorityQueue.poll();
                    n += prevMaxEnemy - e;
                    priorityQueue.add(e);
                }
                k--;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}