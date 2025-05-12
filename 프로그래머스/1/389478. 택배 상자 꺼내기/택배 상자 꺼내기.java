import java.util.*;
class Solution {
   public int solution(int n, int w, int num) {
        int answer = 1;
        List<Stack<Integer>> warehouse = fillWarehouse(n, w);
        
        Stack<Integer> targetStack = warehouse.stream()
                                              .filter(s -> s.contains(num))
                                              .findAny()
                                              .get();//무조건 존재할테니 그냥 get

        while(!targetStack.pop().equals(num)){
            answer++;
        }
       
        return answer;
    }

    private List<Stack<Integer>> fillWarehouse(int n, int w) {
        List<Stack<Integer>> warehouse = new ArrayList<>();

        for(int i = 0; i < w; i++){
            warehouse.add(new Stack<>());
        }

        int tmp = n;
        int order = 0;
        outer:
        for (int i = 0; i < n / w + 1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    warehouse.get(j).push(++order);
                    if (--tmp == 0) break outer;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    warehouse.get(j).push(++order);
                    if (--tmp == 0) break outer;
                }
            }
        }
        return warehouse;
    }
}