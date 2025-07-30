class Solution {
    public int[] solution(int[] arr, int[][] queries) {

        for (int[] query : queries) {
            int start = query[0], end = query[1], target = query[2];
            for (int j = start; j <= end; j++) {
                if (j % target == 0) {
                    arr[j] += 1;
                }
            }
        }

        return arr;
    }
}