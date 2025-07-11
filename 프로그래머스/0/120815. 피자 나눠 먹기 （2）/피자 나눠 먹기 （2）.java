class Solution {
    public int solution(int n) {
        if(n > 6){
            return lcm(n, 6) /6;
        }else{
            return lcm(6,n)/6;
        }
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    private int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }
}