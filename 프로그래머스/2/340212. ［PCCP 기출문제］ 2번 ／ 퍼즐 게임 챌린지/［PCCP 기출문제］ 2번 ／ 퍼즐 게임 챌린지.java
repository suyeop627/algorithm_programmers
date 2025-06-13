class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        long answer = limit;//해결가능한 경우만 입력으로 주어짐
        
        long left =1;
        long right = limit;
        
        while(left <= right){
            
            long mid = (left + right) /2;
            long clearTime = calculateClaerTime(diffs, times, limit, mid);
            
            if(clearTime <= limit){
                answer = mid;
                right = mid - 1;
            } else { 
                left = mid + 1;
            }
        }
        return (int) answer;
        
    }
    
    private long calculateClaerTime(int[] diffs, int[] times, long limit, long level){
        long clearTime = times[0];//처음껀 풂
        for(int i = 1; i < diffs.length; i++){
            if(diffs[i] <= level){
                clearTime += times[i];
            }else {
                clearTime += (diffs[i] - level) * (times[i-1] + times[i]) + times[i];
            }   
            if(clearTime > limit) return limit+ 1;
        }
        return clearTime;
    }
}