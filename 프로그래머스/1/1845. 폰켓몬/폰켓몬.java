import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int n : nums){
            numToCount.put(n, numToCount.getOrDefault(n, 0)+1);
        }
        int kind = numToCount.size();
        
        if(kind >=nums.length/2){
            answer = nums.length/2;
        }else{
            answer = kind;
        }
        return answer;
    }
}