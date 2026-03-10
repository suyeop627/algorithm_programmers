import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int e = 0;
        for(int i =0; i < d.length; i++){
            e += d[i];
            if(e > budget) break;
            
            answer++;
        }
        return answer;
    }
}