class Solution {
    public int solution(int[] num_list) {
        
        int multiplication = 1;
        int squaredSum = 0;
        
        for(int num : num_list){
            multiplication*=num;
            squaredSum+=num;
        }
    
        return multiplication < (int) Math.pow(squaredSum,2) ? 1 : 0;
    }
}