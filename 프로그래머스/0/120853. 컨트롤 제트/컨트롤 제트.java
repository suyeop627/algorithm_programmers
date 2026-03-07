import java.util.*;
class Solution {
    public int solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String str: s.split(" ")){
            if(str.equals("Z")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        int answer = 0;
        
        int size = stack.size();
        for(int i = 0; i < size; i++){
            answer+=stack.pop();
        }
        return answer;
    }
}