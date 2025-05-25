import java.util.*;

public class Solution {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int solution(String[] storage, String[] requests) {

        char[][] warehouse = toCharArrayWithOutline(storage);

        Map<Character, HashSet<int[]>> containerToLocationsMap = mappingContainerToLocationList(warehouse);
        HashSet<int[]> peekedItemIndexes = new HashSet<>();
        int removedContainers = 0;

        for (String req : requests) {
            char targetContainer = req.charAt(0);
            if (!containerToLocationsMap.containsKey(targetContainer)) continue;

            HashSet<int[]> locations = containerToLocationsMap.get(targetContainer);

            boolean isCrane = req.length() == 2;
            Iterator<int[]> iterator = locations.iterator();

            if (isCrane) {
                while (iterator.hasNext()) {
                    int[] location = iterator.next();   
                    warehouse[location[0]][location[1]] = '.';
                    peekedItemIndexes.add(location);
                    iterator.remove();
                    removedContainers++;

                }
            } else {
                while (iterator.hasNext()) {
                    int[] location = iterator.next();
                    if (isAccessible(location, warehouse)) {
                        warehouse[location[0]][location[1]] = '.';
                        peekedItemIndexes.add(location);
                        iterator.remove();
                        removedContainers++;
                    }
                }
            }
            updateWarehouseInfo(peekedItemIndexes, warehouse);
        }

        return storage.length * storage[0].length() - removedContainers;
    }

    private void updateWarehouseInfo(HashSet<int[]> peekedItems, char[][] warehouse) {
        HashSet<int[]> toRemove = new HashSet<>();
        peekedItems.forEach(location -> {
            if (isAccessible(location, warehouse)) {

                Queue<int[]> queue = new LinkedList<>();
                queue.add(location);

                while (!queue.isEmpty()) {
                    int[] curLocation = queue.poll();

                    warehouse[curLocation[0]][curLocation[1]] = '#';
                    for (int i = 0; i < 4; i++) {
                        int nx = curLocation[0] + dx[i];
                        int ny = curLocation[1] + dy[i];

                        if (warehouse[nx][ny] == '.') {
                            queue.offer(new int[]{nx, ny});
                            toRemove.add(location);
                        }
                    }
                }
            }
        });
        peekedItems.removeAll(toRemove);
    }


    private static Map<Character, HashSet<int[]>> mappingContainerToLocationList(char[][] warehouse) {
        Map<Character, HashSet<int[]>> containerToLocationList = new HashMap<>();

        for (int i = 1; i < warehouse.length - 1; i++) {
            for (int j = 1; j < warehouse[0].length - 1; j++) {
                HashSet<int[]> locationList = containerToLocationList.getOrDefault(warehouse[i][j], new HashSet<>());
                locationList.add(new int[]{i, j});
                containerToLocationList.put(warehouse[i][j], locationList);
            }
        }
        return containerToLocationList;
    }

    private boolean isAccessible(int[] location, char[][] warehouse) {
        int cx = location[0];
        int cy = location[1];

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (warehouse[nx][ny] == '#') {
                return true;
            }
        }
        return false;
    }

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
}