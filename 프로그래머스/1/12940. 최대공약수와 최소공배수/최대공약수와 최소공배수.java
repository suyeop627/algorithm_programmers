class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int[] answer = {gcd, lcm(n,m,gcd)};
        return answer;
    }
    
    private int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
    private int lcm(int a, int b, int gcd){
        return (a * b)/gcd;
    }
}