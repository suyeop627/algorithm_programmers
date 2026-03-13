class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row = 1;
        while(true){
            if(yellow % row ==0){
                int yellowWidth = yellow / row;
                int yellowHeight = row;
                if(2 * yellowWidth + 2*yellowHeight == brown - 4){
                    answer[0] = yellowWidth+2;
                    answer[1] = yellowHeight+2;
                    break;
                }

            }
            row++;
        }
        return answer;
    }
}