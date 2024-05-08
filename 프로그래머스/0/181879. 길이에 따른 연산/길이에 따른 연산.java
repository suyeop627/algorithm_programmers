class Solution {
    public int solution(int[] num_list) {
        return num_list.length>10 ? getSum(num_list):getMultiply(num_list);
    }
    private int getSum(int[] num_list){
        int sum =0;
        for(int i : num_list){
            sum+=i;
        }
        return sum;
    }
    
    private int getMultiply(int[] num_list){
        int multiply =1;
        for(int i : num_list){
            multiply*=i;
        }
        return multiply;
    }
}