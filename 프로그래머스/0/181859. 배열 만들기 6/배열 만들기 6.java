import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> stk = new ArrayList<>();
        
        for (int num : arr) {
            if (stk.isEmpty()) {
                stk.add(num);
            } else if (stk.get(stk.size() - 1) == num) {
                stk.remove(stk.size() - 1);
            } else {
                stk.add(num);
            }
        }
        if(stk.isEmpty()){
            return new int[]{-1};
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}