import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        while(true){
            int[] capture = Arrays.copyOf(arr, arr.length);
            boolean isEqual = true;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 ==0){
                    arr[i] /=2;
                }
                if(arr[i] < 50 && arr[i]%2 == 1){
                    arr[i]*=2;
                    arr[i]++;
                }
                
                if(capture[i] != arr[i]){
                    isEqual = false;
                }
            }
            if(isEqual){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}