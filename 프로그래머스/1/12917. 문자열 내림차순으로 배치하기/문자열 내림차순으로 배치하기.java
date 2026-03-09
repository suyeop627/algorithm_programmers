import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, (a,b) -> b.charAt(0) - a.charAt(0));
        return String.join("", arr);
    }
}