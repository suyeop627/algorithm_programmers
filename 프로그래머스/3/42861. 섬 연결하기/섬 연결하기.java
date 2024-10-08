import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[][] islandTable = new int[n][n];
        for (int[] cost : costs) {
            islandTable[cost[0]][cost[1]] = cost[2];
            islandTable[cost[1]][cost[0]] = cost[2];
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int linkedIslandCount = 0;

        while (linkedIslandCount < n - 1) {
            int minCost = Integer.MAX_VALUE;
            int nextIsland = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && islandTable[i][j] != 0) {
                            if (islandTable[i][j] < minCost) {
                                minCost = islandTable[i][j];
                                nextIsland = j;
                            }
                        }
                    }
                }
            }

            if (nextIsland != -1) {
                visited[nextIsland] = true;
                answer += minCost;
                linkedIslandCount++;
            }
        }

        return answer;
    }
}
