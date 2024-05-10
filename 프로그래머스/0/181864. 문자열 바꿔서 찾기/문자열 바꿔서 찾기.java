class Solution {
    public int solution(String myString, String pat) {
        
        String convertedString = myString.replaceAll("A", "b").replaceAll("B", "a");       
        return convertedString.contains(pat.toLowerCase()) ? 1 : 0;
    }
}