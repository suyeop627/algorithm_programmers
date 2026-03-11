import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int lt = 0;
        int rt = arr.length-1;
        
        for(int i = 0; i < query.length; i++){
            if(i % 2 == 0){
                rt = lt + query[i];
            }else{
                lt = lt + query[i];
            }
        }
        
        
        int[] answer = Arrays.copyOfRange(arr, lt, rt+1);
        return answer;
    }
}