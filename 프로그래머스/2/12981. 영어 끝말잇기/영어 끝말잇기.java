import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        Set<String> usedWords = new HashSet<>();
        if(words[0].length() > 1){
            usedWords.add(words[0]);
        }else{
            return new int[]{1,1};
        }

        for(int i = 1; i < words.length; i++){
            char beforeLastLetter = words[i-1].charAt(words[i-1].length()-1);
            if(usedWords.contains(words[i]) 
               ||words[i].length() < 2
               || words[i].charAt(0) != beforeLastLetter){
                answer[0] = i %n +1;
                answer[1] = i/n +1;
                break;
            }else{
                usedWords.add(words[i]);
            }
            
        }

        

        return answer;
    }
}