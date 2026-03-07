import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String sp = String.join("", spell);
        for(String d  :dic){
            if(d.length() != sp.length()) continue;
            
            char[] cArr = d.toCharArray();
            Arrays.sort(cArr);
            if(sp.equals(String.valueOf(cArr))){
                return 1;
            }
        }
        
        return 2;
    }
}