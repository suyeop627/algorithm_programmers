class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        Point point = Point.create();
        for(String input : keyinput){
            switch(input){
                    case "up" -> point.up(board);
                    case "down" -> point.down(board);
                    case "left" -> point.left(board);
                    case "right" -> point.right(board);
            }
        }
        return new int[]{point.x, point.y};
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public static Point create(){
            return new Point(0,0);
        }
        public void up(int[] board){
            if(y +1 <= board[1]/2){
                y++;
            }
        }
        public void down(int[] board){
            if(y -1 >= board[1]/-2){
                y--;
            }
        }
        public void left(int[] board){
            if(x -1 >= board[0]/-2){
                x--;
            }
            
        }
        public void right(int[] board){
            if(x +1 <= board[0]/2){
                x++;
            }
        }
    }
}