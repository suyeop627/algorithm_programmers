class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        cipher = " " + cipher;
        for(int i = code; i < cipher.length(); i+=code){
            answer+=cipher.charAt(i);
        }
        return answer;
    }
}