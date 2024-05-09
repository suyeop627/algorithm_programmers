class Solution {
    public int solution(int a, int b) {
        int lengthOfB = (int) Math.pow(10, String.valueOf(b).length());
        
        return Math.max(a*lengthOfB+b, 2*a*b);
    }
}