import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Comparator;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++){
            int q = food[i] / 2;
            for(int j = 0; j < q; j++){
                sb.append(i);
            }
        }
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}