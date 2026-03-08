class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg = new double[score.length];
        for(int i = 0; i < score.length; i++){
            avg[i] = (score[i][0] + score[i][1])/2.0;
        }
        for(int i = 0; i < avg.length; i++){
            int rank = 1;
            for(int j = 0; j < avg.length; j++){
                if(avg[j] > avg[i]){
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}