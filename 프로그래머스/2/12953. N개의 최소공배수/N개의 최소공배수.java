class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int m = -1;
        
        for(int i = 1; i < arr.length; i++ ){
            m = arr[i];
            int gcd = gcd(answer, m);
            int lcm = answer * m / gcd;
            answer = lcm;
        }
        
        return answer;
    }
    private int gcd (int a, int b){
        if(b ==0){
            return a;
        }
        
        return gcd(b, a%b);
    }
}