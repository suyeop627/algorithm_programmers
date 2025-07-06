import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(d -> d%n == 0).toArray();
    }
}