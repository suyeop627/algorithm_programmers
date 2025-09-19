class Solution {
    public String solution(int age) {
        String strAge = String.valueOf(age);
        String answer = "";
        for(char charAge : strAge.toCharArray()){
            answer+= (char)(charAge-'0'+'a');
        }
        return answer;
    }
}