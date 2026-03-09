import java.util.*;
class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt)
            .sorted().mapToInt(Integer::intValue).toArray();
        
        return arr[0]+" "+ arr[arr.length-1];
    }
}