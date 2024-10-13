public class Solution {
    public String solution(String number, int k) {
        StringBuilder resultSb = new StringBuilder();
        int lengthOfResult = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            while (resultSb.length() > 0 && k > 0 && resultSb.charAt(resultSb.length() - 1) < number.charAt(i)) {
                resultSb.deleteCharAt(resultSb.length() - 1);
                k--;
            }
            
            resultSb.append(number.charAt(i));
        }
        
        if (resultSb.length() > lengthOfResult) {
            resultSb.delete(lengthOfResult, resultSb.length());
        }
        
        return resultSb.toString();
    }
}