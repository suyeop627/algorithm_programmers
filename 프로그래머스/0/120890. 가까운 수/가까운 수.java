class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        for(int i : array){
            int newGap = Math.abs(i-n);
            int answerGap = Math.abs(answer-n);
            if(newGap < answerGap){
                answer = i;
            }else if(newGap == answerGap){
                answer = i < answer ? i : answer;
            }
        }
        return answer;
    }
}