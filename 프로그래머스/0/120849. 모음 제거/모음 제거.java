import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> moum = Set.of('a', 'e', 'i', 'o','u');
        for(int i =0; i < my_string.length(); i++){
            if(!moum.contains(my_string.charAt(i))){
                answer+= my_string.charAt(i);
            }
        }
        return answer;
    }
}