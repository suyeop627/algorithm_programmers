class Solution {
    public long solution(long n) {
        long sqrtN = (long)Math.sqrt(n);
        if(sqrtN * sqrtN == n){
            return (long)Math.pow(sqrtN+1, 2);
        }
        return -1;
    }
}