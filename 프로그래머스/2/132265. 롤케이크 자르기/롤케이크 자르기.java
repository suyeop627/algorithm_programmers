import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> rightToppingToCount = new HashMap<>();
        for (int t : topping) {
            
            rightToppingToCount.put(
                t, 
                rightToppingToCount.getOrDefault(t, 0)+1
            );
        }

        int rightDistinctToppingCount = rightToppingToCount.keySet().size();

        Map<Integer, Integer> leftToppingToCount = new HashMap<>();
        int leftDistinctToppingCount = 0;

        int answer = 0;

        //마지막에 토핑 하나 남겨야 두개로 잘라질 수 있음(끝까지 순회하면 그냥 한덩이)
        for (int i = 0; i < topping.length -1; i++) {
            int current = topping[i];

            leftToppingToCount.put(
                current, 
                leftToppingToCount.getOrDefault(current, 0)+1
            );
            //새토핑인 경우
            if (leftToppingToCount.get(current) == 1) {
                leftDistinctToppingCount++;
            }

            rightToppingToCount.put(current, rightToppingToCount.get(current) - 1);
            //해당 종류의 토핑이 다 없어진 경우
            if (rightToppingToCount.get(current) == 0) {
                rightDistinctToppingCount--;
            }

            if (leftDistinctToppingCount == rightDistinctToppingCount) {
                answer++;
            }
        }

        return answer;
    }
}
