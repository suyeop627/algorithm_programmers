import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        for(String card : cards1){
            queue1.offer(card);
        }
        for(String card : cards2){
            queue2.offer(card);
        }

        for(String word :goal){
            if(!queue1.isEmpty() && queue1.peek().equals(word)) queue1.poll();
            else if (!queue2.isEmpty() &&queue2.peek().equals(word)) queue2.poll();
            else return "No";
        }
        return "Yes";
    }
}