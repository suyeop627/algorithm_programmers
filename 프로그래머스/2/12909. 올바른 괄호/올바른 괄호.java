import java.util.*;
class Solution {
    boolean solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
                
            }
        }
        
        return stack.isEmpty();
    }
}