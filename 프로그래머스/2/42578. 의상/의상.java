import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> partToClothe = new HashMap<>();
        for(String[] clothe : clothes){
            List<String> list = partToClothe.getOrDefault(clothe[1], new ArrayList<String>());
            list.add(clothe[0]);
            partToClothe.put(clothe[1], list);            
        }
        
        for(String key : partToClothe.keySet()){
            int tmp = partToClothe.get(key).size()+1;
            answer*=tmp;
        }
        answer--;
        return answer;
    }
}