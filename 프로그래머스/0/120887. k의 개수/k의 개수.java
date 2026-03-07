class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char ck = (char)((int)'0' + k);
        for(int n = i; n <=j; n++){
            for(char c : String.valueOf(n).toCharArray()){
                if(c == ck){
                    answer++;
                }
            }
        }
        return answer;
    }
}