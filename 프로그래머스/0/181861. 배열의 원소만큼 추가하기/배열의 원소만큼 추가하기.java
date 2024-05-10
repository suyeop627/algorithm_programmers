import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int element : arr){
            for(int i = 0; i<element; i++){
                list.add(element);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}