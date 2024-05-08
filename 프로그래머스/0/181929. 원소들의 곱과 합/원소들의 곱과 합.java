class Solution {
    public int solution(int[] num_list) {
        
        int multiplication = getMultiplication(num_list);
        int squaredSum = getSquaredSum(num_list);
    
        return multiplication < squaredSum ? 1 : 0;
    }
    
    private int getMultiplication(int[] num_list){
        int multiplication = 1;
        for(int num : num_list){
            multiplication*=num;
        }
        return multiplication;
    }
    
    private int getSquaredSum(int[] num_list){
        int sum = 0;
        for(int num : num_list){
            sum+=num;
        }
        return (int)Math.pow(sum,2);
    }
}