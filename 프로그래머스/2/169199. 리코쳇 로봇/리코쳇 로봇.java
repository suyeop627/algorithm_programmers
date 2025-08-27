import java.util.*;
class Solution {
    private final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final int[] robot = new int[2];
    
    public int solution(String[] board) {

        String[][] map = initGame(board);
        Deque<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new int[]{robot[0], robot[1], 0});
        return bfs(map, queue, visited);
    }
    
    private int bfs(String[][] map, Deque<int[]> queue, Set<String> visited){
        while(!queue.isEmpty()){
                
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int loopCount = now[2];
            
            if (map[y][x].equals("G")) {
                return loopCount;
            }
            
            for(int[] d : direction){
                int ny = y;
                int nx = x;
                while(true){
                    //ny, nx 그대로 쓰면 while 탈출할때 처리 애매해짐 -> 임시값 할당해서 처리
                    int ty = ny+d[0];
                    int tx = nx+d[1];
                    
                    if (ty < 0 || ty >= map.length || tx < 0 || tx >= map[0].length 
                        || map[ty][tx].equals("D")) {
                        break;
                    }
                    ny=ty;
                    nx=tx;
                }   
                // System.out.println("ny = "+ny + " , nx = "+nx);
                String key = ny + "|" + nx;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{ny, nx, loopCount + 1});
                }
            }
            
        }
        
        
        return -1;
    }
    
    private String[][] initGame(String[] board){
        String[][] map = new String[board.length][];
        for(int i = 0; i < board.length; i++){
            if(board[i].contains("R")){
                robot[0] = i;
                robot[1] = board[i].indexOf("R");
            }
                
            map[i] = board[i].split("");
        }
        return map;
            
    }
}