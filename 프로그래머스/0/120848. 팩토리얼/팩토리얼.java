class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[11];
        
        arr[1] = 1;
        for(int i = 2; i<=10; i++){
            arr[i] = arr[i-1] * i;
        }
        
        for(int i = 1; i <=10; i++){
            if(arr[i]==n){
                return i;
            }
            if(arr[i] > n){
                return i-1;
            }
        }
        
        return answer;
    }
}