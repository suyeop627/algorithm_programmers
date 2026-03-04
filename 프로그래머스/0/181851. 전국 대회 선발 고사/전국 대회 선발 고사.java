class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        int searchRank = 1;
        int[] attendants = new int[3];
        int attendantsCount = 0;
        
        while(attendantsCount < 3){
            for(int i = 0; i < rank.length; i++){
                if(rank[i] != searchRank){
                    continue;
                }
                
                if(attendance[i]){
                    attendants[attendantsCount] = i;
                    attendantsCount++;
                }
                searchRank++;
                break;
            }
        }
        
        
        
        return attendants[0] * 10000
            + attendants[1] * 100
            + attendants[2];
    }
}