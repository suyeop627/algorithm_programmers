import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        outer:
        for(int element : arr){
            for(int elementToDelete : delete_list){
                if(element == elementToDelete){
                    continue outer;
                }
            }
            list.add(element);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}