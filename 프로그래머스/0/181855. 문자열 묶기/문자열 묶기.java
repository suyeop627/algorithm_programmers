import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> countToLength = new HashMap<>();
        for(String str : strArr){
            countToLength.put(
                str.length(),
                countToLength.getOrDefault(str.length(), 0) +1
            );
        }
        int answer = 0;
        for(Integer key: countToLength.keySet()){
            if(countToLength.get(key) > answer){
                answer=countToLength.get(key);
            }
        }
        
        
        

        return answer;
    }
}