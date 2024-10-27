class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i< my_string.length(); i++){
            char letter = my_string.charAt(i);
            if(letter >= 'a' && letter <='z'){
                answer+=String.valueOf(letter).toUpperCase();
            }else{
                answer+=String.valueOf(letter).toLowerCase();
            }
        }
        return answer;
    }
}