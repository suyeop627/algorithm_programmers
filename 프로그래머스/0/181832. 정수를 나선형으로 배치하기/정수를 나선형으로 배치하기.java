class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int num = 1;
        int[] point = {0, 0};

        Direction direction = Direction.RIGHT;

        answer[0][0] = num++;

        while (num <= n * n) {
            switch (direction) {

                case UP -> {
                    if (point[0] - 1 < 0 || answer[point[0] - 1][point[1]] != 0) {
                        direction = Direction.RIGHT;
                    } else {
                        point[0]--;
                        answer[point[0]][point[1]] = num++;
                    }
                }

                case DOWN -> {
                    if (point[0] + 1 >= n || answer[point[0] + 1][point[1]] != 0) {
                        direction = Direction.LEFT;
                    } else {
                        point[0]++;
                        answer[point[0]][point[1]] = num++;
                    }
                }

                case LEFT -> {
                    if (point[1] - 1 < 0 || answer[point[0]][point[1] - 1] != 0) {
                        direction = Direction.UP;
                    } else {
                        point[1]--;
                        answer[point[0]][point[1]] = num++;
                    }
                }

                case RIGHT -> {
                    if (point[1] + 1 >= n || answer[point[0]][point[1] + 1] != 0) {
                        direction = Direction.DOWN;
                    } else {
                        point[1]++;
                        answer[point[0]][point[1]] = num++;
                    }
                }
            }
        }

        return answer;
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
}