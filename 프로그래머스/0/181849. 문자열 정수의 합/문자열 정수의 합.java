class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] num_strCharArray = num_str.toCharArray();
        for(char num_char : num_strCharArray){
            answer+=num_char-'0';
        }
        return answer;
    }
}