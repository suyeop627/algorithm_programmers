import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = -1;
        HashMap<Integer, Integer>map = new HashMap<>();
        
        int maxCount = 0;
        boolean isDup = false;
        for(int num : array){
            int count =  map.getOrDefault(num, 0)+1;
            map.put(num, count);
            if(count > maxCount){
                answer = num;
                maxCount = count;
                isDup=false;
            }else if(count == maxCount && answer != num){
                isDup = true;
            }
            
            
        }
        return isDup ? -1 : answer;
    }
}