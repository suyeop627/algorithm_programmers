class Solution {
    public int solution(String A, String B) {
        String mergedB = B + B;
        return mergedB.indexOf(A);
    }
}