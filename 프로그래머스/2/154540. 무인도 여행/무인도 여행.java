import java.util.*;

class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        List<Integer> durationList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int duration = dfs(i, j, maps, visited);
                    durationList.add(duration);
                }
            }
        }
        
        if(durationList.isEmpty()) return new int[]{-1};
        
        return durationList.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
    
    private int dfs(int y, int x, String[] maps, boolean[][] visited) {
        visited[y][x] = true;
        int duration = maps[y].charAt(x) - '0'; 
        
        for(int[] direction : directions) {
            int ny = y + direction[0];
            int nx = x + direction[1];
            
            if(ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length()) continue;
            
            if(!visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                duration += dfs(ny, nx, maps, visited);
            }
        }
        
        return duration;
    }
}
