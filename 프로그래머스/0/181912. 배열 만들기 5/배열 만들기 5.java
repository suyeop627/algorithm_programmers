import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        for(String intStr : intStrs){
            list.add(Integer.parseInt(intStr.substring(s,s+l)));
        }
        return list.stream()
            .filter(i -> i > k)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}