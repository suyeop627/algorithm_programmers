import java.lang.StringBuilder;
class Solution {
    public String solution(String my_string, int s, int e) {
        char[] arr = my_string.toCharArray();
        
        while (s < e) {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        
        return String.valueOf(arr);
    }
}