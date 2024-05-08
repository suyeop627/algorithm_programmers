import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int lastElement = num_list[num_list.length-1] > num_list[num_list.length-2] 
            ? num_list[num_list.length-1]-num_list[num_list.length-2] 
            : num_list[num_list.length-1]*2;
        int[] answer = Arrays.copyOf(num_list, num_list.length+1);
        answer[answer.length-1] = lastElement;
        return answer;
    }
}