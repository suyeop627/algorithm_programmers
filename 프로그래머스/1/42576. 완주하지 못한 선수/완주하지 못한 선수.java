import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        Map<String, Integer> nameToCount = new HashMap<>();
        for(String p: participant){
            nameToCount.put(p, nameToCount.getOrDefault(p, 0) +1);
        }
        for(String c: completion){
            nameToCount.put(c, nameToCount.getOrDefault(c, 0) -1);
            if(nameToCount.get(c) == 0){
                nameToCount.remove(c);
            }
            
        }
        for(String s : nameToCount.keySet()){
            answer = s;
        }
        return answer;
    }
}