import java.util.*;

class Solution {
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final int[] robot = new int[2];

    public int solution(String[] board) {

        char[][] map = initGame(board);
        Deque<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{robot[0], robot[1], 0});
        return bfs(map, queue, visited);
    }

    private int bfs(char[][] map, Deque<int[]> queue, Set<String> visited) {
        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int moveCount = now[2];

            if (map[y][x]=='G') {
                return moveCount;
            }

            for (int[] direction : DIRECTIONS) {
                int[] nextPosition = slideRobot(y, x, direction, map);
                String key = nextPosition[0] + "|" + nextPosition[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{nextPosition[0], nextPosition[1], moveCount + 1});
                }
            }
        }

        return -1;
    }

    private int[] slideRobot(int y, int x, int[] direction, char[][] map) {
        int[] nextPosition = new int[]{y, x};
        while (true) {
            int ty = nextPosition[0] + direction[0];
            int tx = nextPosition[1] + direction[1];

            if (ty < 0 || ty >= map.length || tx < 0 || tx >= map[0].length || map[ty][tx]==('D')) {
                break;
            }
            nextPosition[0] = ty;
            nextPosition[1] = tx;
        }
        return nextPosition;
    }

    private char[][] initGame(String[] board) {
        char[][] map = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains("R")) {
                robot[0] = i;
                robot[1] = board[i].indexOf("R");
            }

            map[i] = board[i].toCharArray();
        }
        return map;

    }
}