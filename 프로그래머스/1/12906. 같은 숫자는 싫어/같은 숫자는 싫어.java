import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i : arr){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(stack.peek() != i){
                    stack.push(i);
                }
            }
        }
        int size = stack.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = stack.pollLast();
        }

        return answer;
    }
}