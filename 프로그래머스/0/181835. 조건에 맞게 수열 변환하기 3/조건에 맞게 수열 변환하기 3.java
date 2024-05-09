class Solution {
    public int[] solution(int[] arr, int k) {
        if(k%2==0){
            addK(arr, k);  
        }else{
            multiplyK(arr,k); 
        }  
        return arr;
    }
    
    private void addK(int[] arr, int k){
        for(int i=0; i<arr.length; i++){
            arr[i]+=k;
        }
    }
    
    private void multiplyK(int[] arr, int k){
        for(int i=0; i<arr.length; i++){
            arr[i]*=k;
        }
    }
}