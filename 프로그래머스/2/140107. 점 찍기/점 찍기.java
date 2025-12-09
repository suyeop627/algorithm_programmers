class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (long x = 0; x <= d; x += k) {
            //x^2 y^2 =  d^2
            long y = (long)Math.sqrt((long)d*d - x*x);
            answer+= y/k +1;//x=0 포함
        }

        return answer;
    }
}