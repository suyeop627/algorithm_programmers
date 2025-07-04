class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int length = pat.length();
        int lastIndex = length;
        for(int i = 0; i < myString.length()-length+1; i++){
            if(myString.substring(i, lastIndex).equals(pat)){
                answer++;
            }
            lastIndex++;
        }
        return answer;
    }
}