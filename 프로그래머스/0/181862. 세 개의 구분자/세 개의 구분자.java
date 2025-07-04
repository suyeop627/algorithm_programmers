import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] splited = myStr.replaceAll("[abc]", " ").replaceAll(" +"," ").split(" ");
        String[] answer = Arrays.stream(splited).filter(s -> !s.isEmpty()).toArray(String[]::new);
        if(answer.length ==0){
            return new String[]{"EMPTY"};
        }
        return answer;
    }
}