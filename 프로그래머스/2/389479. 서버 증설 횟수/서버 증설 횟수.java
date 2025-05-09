import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] players, int capacity, int duration) {
        int answer = 0;
        Queue<Integer> serverQueue = new LinkedList<>();

        for (int currentTime = 0; currentTime < 24; currentTime++) {
            while (hasExpiredServer(serverQueue, currentTime)) {
                serverQueue.remove();
            }

            if (players[currentTime] > serverQueue.size() * capacity) {
                while (isScaleOutNeeded(serverQueue, capacity, players[currentTime])) {
                    serverQueue.add(currentTime + duration);
                    answer++;
                }
            }
        }
        return answer;
    }

    private boolean isScaleOutNeeded(Queue<Integer> serverQueue, int capacity, int players) {
        return players >= (serverQueue.size() + 1) * capacity;
    }

    private boolean hasExpiredServer(Queue<Integer> serverQueue, int currentTime) {
        return !serverQueue.isEmpty() && serverQueue.peek() <= currentTime;
    }
}