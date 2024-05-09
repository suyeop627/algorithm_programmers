class Solution {
    public int solution(int a, int b) {
        return Integer.parseInt(String.valueOf(a)+b) > Integer.parseInt(String.valueOf(b)+a) 
            ? Integer.parseInt(String.valueOf(a)+b)
            : Integer.parseInt(String.valueOf(b)+a);
    }
}