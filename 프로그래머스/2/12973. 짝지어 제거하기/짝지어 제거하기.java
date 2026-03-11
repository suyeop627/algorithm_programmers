import java.util.*;
class Solution{
    public int solution(String s){
        int answer = -1;

        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}