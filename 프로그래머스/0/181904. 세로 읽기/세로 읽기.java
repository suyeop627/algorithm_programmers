class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[] my_string_charArray = my_string.toCharArray();
        for(int i = -1; i< my_string_charArray.length-1; i+=m){
            answer+=my_string_charArray[i+c];
        }
        return answer;
    }
}