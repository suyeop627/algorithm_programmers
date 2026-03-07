class Solution {
    int[] fibo;
    public int solution(int n) {
        fibo = new int[n+1];
        dfs(n);
        return fibo[n];
    }
    public int dfs(int n){
        if(fibo[n] > 0){
            return fibo[n];
        }
        if(n <= 2){
            return fibo[n] = 1;
        }else{
            return fibo[n] = (dfs(n-1) + dfs(n-2))%1234567;
        }
    }
}