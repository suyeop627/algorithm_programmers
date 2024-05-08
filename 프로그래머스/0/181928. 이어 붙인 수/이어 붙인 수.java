class Solution {
    public int solution(int[] num_list) {
        
        int oddSum = 0;
        int evenSum = 0;
        
        for(int i : num_list){
            if(i%2==0){
                evenSum = evenSum*10 + i;
            }else{
                oddSum = oddSum*10 +i;
            }
        }
        
        return evenSum + oddSum;
    }
}