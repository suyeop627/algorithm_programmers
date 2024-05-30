import java.util.OptionalInt;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        OptionalInt optional = IntStream.range(idx, arr.length).filter(i->arr[i]==1).findFirst();
        
        return optional.orElse(-1);
    }
}