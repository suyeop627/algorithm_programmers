import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arr.length){
            if(list.isEmpty()){
                list.add(arr[i++]);
            }else if(list.get(list.size()-1) < arr[i]){
                list.add(arr[i++]);
            }else {
                list.remove(list.size()-1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}