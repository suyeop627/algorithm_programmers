import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] citations) {
        int[] sortedArr = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        int hIndex = 0;
        for(int i = 0; i < sortedArr.length; i++){
            if (sortedArr[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }
}