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
            int minCost = Integer.MAX_VALUE; //cost 최소값 미정으로, int 최대값으로 지정
            int nextIsland = -1; //이번 순회에서 이어질 섬 번호 저장

            //방문한 섬에서 최소 비용으로 이어질 미방문 섬 선택
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
            //미방문 섬 방문처리, 비용합산, 연결된 섬 +1
            if (nextIsland != -1) {
                visited[nextIsland] = true;
                answer += minCost;
                linkedIslandCount++;
            }
        }

        return answer;
    }
}
