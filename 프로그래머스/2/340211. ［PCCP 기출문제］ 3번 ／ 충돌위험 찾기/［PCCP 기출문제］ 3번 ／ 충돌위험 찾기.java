import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        //route의 point 번호를 실제 좌표로 치환
        int[][][] routesPoint = new int[routes.length][routes[0].length][2];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                for (int k = 0; k < 2; k++) {
                    routesPoint[i][j][k] = points[routes[i][j] - 1][k];
                }
            }
        }
        
        //로봇 별 총 이동경로 저장
        HashMap<Integer, ArrayList<int[]>> robotToRoutes = new HashMap<>();
        for (int i = 0; i < routesPoint.length; i++) {
            ArrayList<int[]> totalRoute = getTotalRoute(routesPoint[i]);
            robotToRoutes.put(i, totalRoute);
        }

        int time = 0;
        boolean isRunningRobotExist = true;

        //각 시간에 point별 로봇의 수 저장
        HashMap<String, Integer> pointToRobotCount = new HashMap<>();
        while (isRunningRobotExist) {
            int stoppedRobotCount = 0;

            for (Integer id : robotToRoutes.keySet()) {
                //모든 경로 다 진행했으면 continue
                if (robotToRoutes.get(id).size() - 1 < time) {
                    stoppedRobotCount++;
                    continue;
                }

                int[] nowPoint = robotToRoutes.get(id).get(time);
                String newPosition = String.format("%d|%d", nowPoint[0], nowPoint[1]);

                //현재 로봇이 위치한 point에 다른 로봇이 있는지 확인
                if (pointToRobotCount.containsKey(newPosition)) {
                    pointToRobotCount.put(newPosition, pointToRobotCount.get(newPosition) + 1);
                } else {
                    pointToRobotCount.put(newPosition, 1);
                }
            }
            //현재시간 로봇이 있는 point별 로봇의 수가 2이상이면 충돌위험 ++
            for (Integer count : pointToRobotCount.values()) {
                if (count > 1) {
                    answer++;
                }
            }

            if (stoppedRobotCount == robotToRoutes.size()) {
                isRunningRobotExist = false;
            }
            time++;
            pointToRobotCount.clear();
        }
        return answer;
    }

    private ArrayList<int[]> getTotalRoute(int[][] route) {
        ArrayList<int[]> totalRoute = new ArrayList<>();
        int x = route[0][0];
        int y = route[0][1];

        totalRoute.add(new int[]{x, y});

        for (int[] nextPoint : route) {
            while (x != nextPoint[0] || y != nextPoint[1]) {
                if (x > nextPoint[0]) {
                    x--;
                } else if (x < nextPoint[0]) {
                    x++;
                } else {
                    if (y > nextPoint[1]) {
                        y--;
                    } else {
                        y++;
                    }
                }
                totalRoute.add(new int[]{x, y});
            }
        }
        return totalRoute;
    }
}