import java.util.*;

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[] start = null;
        int[] lever = null;
        int[] exit = null;

        //시작, 출구, 레버 위치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch(maps[i].charAt(j)){
                    case 'S' -> start = new int[]{i, j};
                    case 'L' -> lever = new int[]{i, j};
                    case 'E' -> exit = new int[]{i, j};
                }
            }
        }

        // 시작 -> 레버  
        int distanceToLever = bfs(maps, start, lever);
        if (distanceToLever == -1) return -1;

        // 레버 -> 출구
        int distanceToExit = bfs(maps, lever, exit);
        if (distanceToExit == -1) return -1;

        return distanceToLever + distanceToExit;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        queue.offer(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int row = currentPosition[0];
            int col = currentPosition[1];
            int distance = currentPosition[2];

            if (row == target[0] && col == target[1]) return distance;

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                //map을 벗어난 경우
                if (nextRow < 0 || nextRow >= maps.length 
                    || nextCol < 0 || nextCol >= maps[0].length()) 
                    continue;
                
                //벽인 경우
                if (maps[nextRow].charAt(nextCol) == 'X') continue;

                //이미 방문한 경우
                if (visited[nextRow][nextCol]) continue;
                visited[nextRow][nextCol] = true;

                queue.offer(new int[]{nextRow, nextCol, distance + 1});
            }
        }
        //못나감
        return -1;
    }
}