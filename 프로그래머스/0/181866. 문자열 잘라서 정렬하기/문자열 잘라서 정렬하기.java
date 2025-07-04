import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        String[] splited = myString.replaceAll("x+","x").split("x");

        String[] answer = Arrays.stream(splited)
            .filter(s -> !s.isEmpty())
            .sorted()
            .toArray(String[]::new);
        return answer;
    }
}