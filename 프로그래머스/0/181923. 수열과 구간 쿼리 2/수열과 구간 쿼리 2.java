class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int start = query[0], end = query[1], target = query[2];

            int min = Integer.MAX_VALUE;

            for (int j = start; j <= end; j++) {
                if (arr[j] > target) {
                    min = Math.min(arr[j], min);
                }
            }
            answer[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        
        return answer;
    } 
}
