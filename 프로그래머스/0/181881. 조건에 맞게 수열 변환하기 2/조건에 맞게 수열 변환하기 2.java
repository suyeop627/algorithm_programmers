import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        while(true){
            boolean changed = false;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 ==0){
                    arr[i] /=2;
                    changed = true;
                }else if(arr[i] < 50 && arr[i]%2 == 1){
                    arr[i]*=2;
                    arr[i]++;
                    changed = true;
                }
            }
            if(!changed){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}