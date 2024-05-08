class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = n%2==0 ? 2 : 1;
        
        for(int i = start; i<=n; i+=2){
            int value = i;
            if(start==2){
                value = value*value;
            }
            answer+=value;
        }
        
        
        return answer;
    }
}