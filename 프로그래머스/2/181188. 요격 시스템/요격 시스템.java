import java.util.Arrays;

class Solution {

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        //print(targets);

        int firePoint = -1;

        for (int[] target : targets) {
            if (firePoint <= target[0]) {
                answer++;
                firePoint = target[1];
            }
        }
        return answer;
    }

    private static void print(int[][] targets) {
        for (int[] target : targets) {
            int start = target[0] * 10;
            int end = target[1] * 10;

            for (int j = 0; j <= targets[targets.length - 1][1] * 10; j++) {
                if (start == j) {
                    System.out.print("o");
                } else if (start < j && end > j) {
                    System.out.print("-");
                } else if (end == j) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}