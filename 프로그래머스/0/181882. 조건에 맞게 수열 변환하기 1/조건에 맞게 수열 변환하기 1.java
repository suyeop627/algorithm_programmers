class Solution {
    public int[] solution(int[] arr) {
        for(int i =0; i<arr.length; i++){
            if(isMoreThanFifthyAndEven(arr[i])){
                arr[i] = arr[i]/2;
            } else if(isUnderFifthyAndOdd(arr[i])){
                arr[i] = arr[i]*2;
            }
        }
        return arr;
    }
    
    private boolean isMoreThanFifthyAndEven(int num){
        return num>=50 && num%2==0;
    }
    
    private boolean isUnderFifthyAndOdd(int num){
        return num<50 && num%2==1;
    }
}