import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = Set.of(s1);
        for(String s : s2){
            if(set.contains(s)){
                answer++;
            }
        }
        return answer;
    }
}