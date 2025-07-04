import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        //로봇 별 총 이동경로 저장
        HashMap<Integer, ArrayList<int[]>> robotToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[][] routesPoint = new int[routes[i].length][2];
            for(int j = 0; j < routes[i].length; j++) {
                routesPoint[j] = points[routes[i][j]-1];
            }
            ArrayList<int[]> totalRoute = getTotalRoute(routesPoint);
            robotToRoutes.put(i, totalRoute);
        }


        int time = 0;

        //각 시간에 point별 로봇의 수 저장
        while (true) {
            HashMap<String, Integer> pointToRobotCount = new HashMap<>();
            int stoppedRobotCount = 0;

            for (Integer id : robotToRoutes.keySet()) {
                //모든 경로 다 진행했으면 continue
                if (robotToRoutes.get(id).size() <= time) {
                    stoppedRobotCount++;
                    continue;
                }

                int[] nowPoint = robotToRoutes.get(id).get(time);
                String newPosition = String.format("%d|%d", nowPoint[0], nowPoint[1]);

                //현재 로봇이 위치한 point에 로봇 수 +1
                pointToRobotCount.put(newPosition, pointToRobotCount.getOrDefault(newPosition, 0) + 1);
            }
            //현재시간 로봇이 있는 point별 로봇의 수가 2이상이면 충돌위험 ++
            for (Integer count : pointToRobotCount.values()) {
                if (count > 1) answer++;
            }

            if (stoppedRobotCount == robotToRoutes.size()) {
                break;
            }
            time++;
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
                if (x != nextPoint[0]) {
                    x += x > nextPoint[0] ? -1 : 1;
                } else {
                    y += y > nextPoint[1] ? -1 : 1;
                }
                totalRoute.add(new int[]{x, y});
            }
        }
        return totalRoute;
    }
}
