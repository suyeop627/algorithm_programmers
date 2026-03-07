import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String tmp = "";
        for(int i = 0; i < my_string.length(); i++){
            if(Character.isDigit(my_string.charAt(i))){
                tmp+=my_string.charAt(i);
            }else{
                if(tmp.length() > 0){
                    answer += Integer.parseInt(tmp);
                    tmp="";
                }
            }
        }
        if(tmp.length() > 0){
            answer+= Integer.parseInt(tmp);
        }
        return answer;
    }
}