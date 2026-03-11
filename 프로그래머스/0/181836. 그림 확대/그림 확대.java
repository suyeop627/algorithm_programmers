import java.lang.StringBuilder;
class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int answerIndex = 0;
        for(int i = 0; i < picture.length; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : picture[i].toCharArray()){
                for(int j = 0; j < k; j++){
                    sb.append(c);
                }
            }
            for(int j = 0; j < k; j++){
                answer[answerIndex++] = sb.toString();
            }
            
        }
        
        return answer;
    }
}