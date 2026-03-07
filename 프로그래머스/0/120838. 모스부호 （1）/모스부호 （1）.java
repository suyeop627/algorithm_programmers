import java.util.*;
import java.lang.*;
class Solution {
    public String solution(String letter) {
        String[] morseCodes  = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        
        Map<String, Character> codeToLetter = new HashMap<>();
        for(int i = 0; i< morseCodes.length; i++){
            codeToLetter.put(morseCodes[i], (char)('a'+i));
        }
        StringBuilder sb = new StringBuilder();
        for(String morseCode: letter.split(" ")){
            sb.append(codeToLetter.get(morseCode));
        }

        return sb.toString();
    }
}