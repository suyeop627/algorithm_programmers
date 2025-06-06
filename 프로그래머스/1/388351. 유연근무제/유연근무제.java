class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] week = new int[7];
        
        for(int i = 0; i < 7; i++){
            if(startday==6 || startday==7){
              week[i] = -1;
            }
            startday++;
            
            startday = startday > 7 ? startday / 7 : startday;
        }
        
        for(int i = 0; i<schedules.length; i++){
            boolean isLate = false;
            int limit = (schedules[i] / 100) * 60 + (schedules[i]%100) +10;
        
            for(int j = 0; j < timelogs[0].length; j++){
                if(week[j]==-1){
                    continue;
                }
                int timelog = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);        
                
                if(limit < timelog){
                    isLate = true;
                    break;
                }
                
            }
            if(!isLate) answer++;
        }
        
        return answer;
    }
}