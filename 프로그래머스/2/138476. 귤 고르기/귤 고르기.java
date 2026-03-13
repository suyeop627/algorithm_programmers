import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeToCount = new HashMap<>();
        for(int t : tangerine){
            sizeToCount.put(t, sizeToCount.getOrDefault(t, 0) +1);
        }
        
        List<Integer> countList = sizeToCount.values().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        int answer = 0;
        for(int c : countList){
            k-=c;
            answer++;
            if(k <= 0){
                break;
            }
        }
        
        
        return answer;
    }
}