import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[^0-9]", "");
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
    }
}