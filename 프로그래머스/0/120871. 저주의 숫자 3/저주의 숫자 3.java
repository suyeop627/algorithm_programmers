class Solution {
    public int solution(int n) {
        int answer = 1;
        int cnt = 1;
        while(cnt < n){
            cnt++;
            answer++;
            while(answer%3 ==0 || String.valueOf(answer).contains("3")){
                answer++;
            }
        }
        return answer;
    }
}