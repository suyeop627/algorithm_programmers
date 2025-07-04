import java.util.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i] *2 ; j++){
                    deque.offerLast(arr[i]);
                }
            }else{
                for(int j = 0; j < arr[i]; j++){
                    deque.pollLast();
                }
            }
        }
        
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}