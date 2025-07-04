class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        char[] codeLetters = code.toCharArray();
        for(int i = 0; i < codeLetters.length; i++){
            if(i %q == r){
                answer+=codeLetters[i];
            }
        }
        return answer;
    }
}