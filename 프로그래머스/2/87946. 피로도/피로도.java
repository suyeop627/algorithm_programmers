class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, dungeons, visited, 0);
    }

    private int dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                int countDungeons = dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                maxCount = Math.max(maxCount, countDungeons);
                visited[i] = false; 
            }
        }

        return maxCount;
    }
}