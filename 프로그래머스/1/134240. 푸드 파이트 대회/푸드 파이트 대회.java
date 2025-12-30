import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Comparator;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 1; i < food.length; i++){
            int q = food[i] / 2;
            for(int j = 0; j < q; j++){
                answer += i;
            }
        }
        
        // System.out.println(answer);
        
        StringBuilder sb = new StringBuilder(answer);
        
        
        return answer + "0" + sb.reverse().toString();
    }
}