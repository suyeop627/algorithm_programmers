import java.util.*;

public class Solution {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int solution(String[] storage, String[] requests) {

        char[][] warehouse = toCharArrayWithOutline(storage);
        Map<Character, HashSet<Location>> containerToLocationsMap = mappingContainerToLocationList(warehouse);
        HashSet<Location> peekedItemIndexes = new HashSet<>();

        int removedContainers = 0;

        for (String req : requests) {
            char targetContainer = req.charAt(0);
            if (!containerToLocationsMap.containsKey(targetContainer)) continue;

            HashSet<Location> locations = containerToLocationsMap.get(targetContainer);

            boolean isCrane = req.length() == 2;

            Iterator<Location> iterLocations = locations.iterator();
            while (iterLocations.hasNext()) {
                Location location = iterLocations.next();
                if (isCrane || isAccessible(location, warehouse)) {
                    //출고된 컨테이너의 값을 '.'로 변경
                    warehouse[location.x][location.y] = '.';
                    peekedItemIndexes.add(location);
                    //컨테이너의 위치 목록에서 제거
                    iterLocations.remove();
                    removedContainers++;
                }
            }
            updateWarehouseInfo(peekedItemIndexes, warehouse);
        }
        return storage.length * storage[0].length() - removedContainers;
    }

    // '.'가 저장된 위치를 기준으로 #에 연결가능한지 확인
    //.와 #가 연결 가능할 경우 .를 #로 업데이트
    private void updateWarehouseInfo(HashSet<Location> peekedItemIndexes, char[][] warehouse) {
        HashSet<Location> newlyConnectedToOutside = new HashSet<>();

        peekedItemIndexes.forEach(location -> {
            //.인 위치가 #와 이어져 있는지 확인
            if (isAccessible(location, warehouse)) {
                Queue<Location> queue = new LinkedList<>();
                queue.add(location);

                while (!queue.isEmpty()) {
                    Location curLocation = queue.poll();
                    //#외 이어진 현재 .의 값을 #로 변경
                    warehouse[curLocation.x][curLocation.y] = '#';
                    newlyConnectedToOutside.add(location);
                    for (int i = 0; i < 4; i++) {
                        int nx = curLocation.x + dx[i];
                        int ny = curLocation.y + dy[i];
                        //현재 위치의 상하좌우에 .가 있는지 확인해서 있으면 큐에 저장
                        if (warehouse[nx][ny] == '.') {
                            queue.offer(new Location(new int[]{nx, ny}));
                        }
                    }
                }
            }
        });
        //'.'에서 '#'로 변경된 것들 제거
        peekedItemIndexes.removeAll(newlyConnectedToOutside);
    }

    //컨테이너 별 위치 반환
    private Map<Character, HashSet<Location>> mappingContainerToLocationList(char[][] warehouse) {
        Map<Character, HashSet<Location>> containerToLocationList = new HashMap<>();

        for (int i = 1; i < warehouse.length - 1; i++) {
            for (int j = 1; j < warehouse[0].length - 1; j++) {
                HashSet<Location> locationList = containerToLocationList.getOrDefault(warehouse[i][j], new HashSet<>());
                locationList.add(new Location(new int[]{i, j}));
                containerToLocationList.put(warehouse[i][j], locationList);
            }
        }
        return containerToLocationList;
    }

    //현재 좌표의 상하좌우에 #이 존재하는지 확인
    private boolean isAccessible(Location location, char[][] warehouse) {
        int cx = location.x;
        int cy = location.y;

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (warehouse[nx][ny] == '#') {
                return true;
            }
        }
        return false;
    }

    //배열의 가장자리에 # 추가해서 반환
    private char[][] toCharArrayWithOutline(String[] storage) {
        char[][] arrWithOutline = new char[storage.length + 2][storage[0].length() + 2];
        Arrays.stream(arrWithOutline).forEach(arr -> Arrays.fill(arr, '#'));

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                arrWithOutline[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        return arrWithOutline;
    }


    class Location {
        int x;
        int y;

        public Location(int[] location) {
            x = location[0];
            y = location[1];
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }
    }
}