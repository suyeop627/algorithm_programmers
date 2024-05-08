class Solution {
    public int solution(int[] num_list) {
        
        String oddSum = "";
        String evenSum = "";
        
        for(int i : num_list){
            if(i%2==0){
                evenSum+=i;
            }else{
                oddSum+=i;
            }
        }
        
        return Integer.parseInt(evenSum) + Integer.parseInt(oddSum);
    }
}