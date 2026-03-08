import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for(String s : arr){
            if(Character.isDigit(s.charAt(0))){
                if(!stack.isEmpty()){
                    String op = stack.pop();
                    int num = Integer.parseInt(s);
                    if(op.equals("+")){
                        answer +=num;
                    }else{
                        answer-=num;
                    }
                }else{
                    answer+= Integer.parseInt(s);
                }
            }else{
                stack.push(s);
            }
        }
        return answer;
    }
}