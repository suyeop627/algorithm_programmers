class Solution {
    public long solution(int price, int money, int count) {

        
        long c = (long) count;
        
        long result = price * (c*(c+1))/2 - money;
        return  result > 0 ? result : 0L;
    }
}