class Solution {
    public int[] solution(int[] arr) {
        int from = -1;
        int to = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (from == -1) {
                    from = i;
                }
                to = i;
            }
        }

        if (from == -1) {
            return new int[]{-1};
        }

        int[] answer = new int[to - from + 1];
        System.arraycopy(arr, from, answer, 0, to - from + 1);

        return answer;
    }
}
