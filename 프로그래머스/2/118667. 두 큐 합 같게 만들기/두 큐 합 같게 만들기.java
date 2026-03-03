import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int len = queue1.length;
        
        
        long sum1 = 0;
        
        
        for (int e : queue1) {
            sum1 += e;
        }
        
        long sum2 = 0;
        for (int e : queue2) {
            sum2 += e;
        }
        
        long sumAll = sum1 + sum2;
        
        if (sumAll % 2 != 0) {
            return -1;
        }
        
        long target = sumAll / 2;
        
        
        
        
        int[] arr = new int[len * 2];
        
        for(int i = 0; i < len; i++){
            arr[i] = queue1[i];
            arr[i+len] = queue2[i];
        }
        
        int left = 0;
        int right = len;
        
        
        int count = 0;
    
        while (true) {
            if (sum1 == target) {
                return count;
            }
            
            if (sum1 < target) {
                sum1 += arr[right];
                right++;
            } else {
                sum1 -= arr[left];
                left++;
            }
            
            count++;
            if(right ==left || right ==len*2){
                return -1;
            }
        }
        
    }
}