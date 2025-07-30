import java.util.Arrays;

class Solution {
public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int firePoint = -1;

        for (int[] target : targets) {
            if (firePoint <= target[0]) {
                answer++;
                firePoint = target[1];
            }
        }
        return answer;
    }
}