class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int x = n/a;
            int y = n%a;
            int z = x*b;
            
            
            n = z + y;
            answer+=z;
        }
        return answer;
    }
}