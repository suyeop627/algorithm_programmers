import java.util.*;
class Solution {
    public String solution(String my_string) {

        Set<Character> set = new HashSet<>();
        char[] charArr = my_string.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(set.contains(charArr[i])){
                charArr[i]='@';
            }else{
                set.add(charArr[i]);
            }
        }
        return String.valueOf(charArr).replaceAll("@", "");
    }
}