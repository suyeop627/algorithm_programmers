class Solution {
    public int solution(String[] board) {
        
        
        int countX =0;
        int countO = 0;
        for(int i = 0; i < board.length; i++){
            for(char c : board[i].toCharArray()){
                if(c=='X') countX++;                    
                else if (c=='O') countO++;
            }
        }
        if(countO != countX && countO-countX!= 1 ) return 0;
        
        String[] line = new String[8];
        line[0] = board[0];
        line[1] = board[1];
        line[2] = board[2];
        line[3] = ""+board[0].charAt(0) + board[1].charAt(0) + board[2].charAt(0);
        line[4] = ""+board[0].charAt(1) + board[1].charAt(1) + board[2].charAt(1);
        line[5] = ""+board[0].charAt(2) + board[1].charAt(2) + board[2].charAt(2);
        line[6] = ""+board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        line[7] = ""+board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        int connectedO = 0; int connectedX = 0;
        for(String l : line){
            if(l.equals("OOO")) connectedO++;
            else if(l.equals("XXX")) connectedX++;    
        }
        if(connectedX >0 && connectedO > 0) return 0;
        if(connectedO >0 && countX>=countO) return 0;
        if(connectedX > 0 && countX != countO) return 0;
        return 1;
    }
}