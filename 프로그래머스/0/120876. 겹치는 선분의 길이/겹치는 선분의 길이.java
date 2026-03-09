import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[201];

        for(int[] l : lines){
            for(int i = l[0]; i < l[1]; i++){
                line[i + 100]++;
            }
        }

        for(int l : line){
            if(l >= 2){
                answer++;
            }
        }

        return answer;
    }
}