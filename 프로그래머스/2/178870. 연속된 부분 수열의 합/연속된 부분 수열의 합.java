class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int[] subSums = new int[sequence.length];

        subSums[0] = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            subSums[i] = sequence[i] + subSums[i - 1];
        }

        if (sequence[0] == k) {
            return new int[]{0, 0};
        }

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (start < sequence.length && end < sequence.length) {
            int subSum = subSums[end] - subSums[start] + sequence[start];

            if (subSum == k) {
                int length = end - start + 1;
                if (minLength > length || (minLength == length && answer[0] > start)) {
                    answer[0] = start;
                    answer[1] = end;
                    minLength = length;
                }
                start++;
            } else if (subSum < k) {
                end++;
            } else {
                start++;
            }
        }

        return answer;
    }
}