import java.lang.StringBuilder;
class Solution {
    public String[] solution(String my_str, int n) {
        int length = my_str.length() %n==0 ? my_str.length() /n : my_str.length()/n +1;
        String[] answer = new String[length];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : my_str.toCharArray()){
            sb.append(c);
            if(sb.length() ==n){
                answer[i] = sb.toString();
                sb.setLength(0);
                i++;
            }
        }
        if(sb.length() > 0){
            answer[i] = sb.toString();
        }
        return answer;
    }
}