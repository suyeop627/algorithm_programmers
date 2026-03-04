import java.lang.StringBuilder;
class Solution {
    public String solution(String my_string, int s, int e) {
        String front = my_string.substring(0, s);
        String middle = my_string.substring(s, e+1);
        String back = my_string.substring(e+1);
        
        
        StringBuilder sb = new StringBuilder(middle);
        middle = sb.reverse().toString();
        
        return front+middle+back;
    }
}