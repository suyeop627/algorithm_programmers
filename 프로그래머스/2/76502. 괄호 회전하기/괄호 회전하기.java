import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> closeToOpen = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        
        String rotatedS = s;
        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for(char c : rotatedS.toCharArray()){
                if(!stack.isEmpty() 
                   && closeToOpen.containsKey(c)
                  && closeToOpen.get(c) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(c);
                }
                
            }
            
            if(stack.isEmpty()){
                answer++;
            }
            rotatedS = rotatedS.substring(1) + rotatedS.substring(0,1);
        }
        return answer;
    }
}