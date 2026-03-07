import java.util.*;
class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for(char c : before.toCharArray()){
            charToCount.put(c, charToCount.getOrDefault(c, 0) +1);
        }
        
        for(char c : after.toCharArray()){
            if(!charToCount.containsKey(c)){
                return 0;
            }
            charToCount.put(c, charToCount.get(c) -1);
            if(charToCount.get(c) ==0){
                charToCount.remove(c);
            }
        }
        if(!charToCount.isEmpty()){
            return 0;
        }
        
        
        return 1;
    }
}