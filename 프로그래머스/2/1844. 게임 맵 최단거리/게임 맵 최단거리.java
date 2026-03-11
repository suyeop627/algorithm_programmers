import java.util.*;
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    private int bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        maps[0][0] = 0;
        
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==maps.length-1 &&now[1]==maps[0].length-1){
                return now[2];
            }
            
            for(int i=0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int distance = now[2];
                if(nx < maps.length && nx >=0 && ny < maps[0].length &&ny>=0 && maps[nx][ny]==1){
                    maps[nx][ny] = 0;
                    queue.offer(new int[]{nx,ny, distance+1});
                }
            }
            
        }
        return -1;
    }
}