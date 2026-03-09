class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int nCnt = get1Count(n);

        while(true){
            n++;
            if(get1Count(n) == nCnt){
                answer = n;
                break;
            }
        }
        return answer;
    }
    private int get1Count(int n){
        int cnt = 0;
        String bi = Integer.toBinaryString(n);
        for(char c : bi.toCharArray()){
            if(c=='1'){
                cnt++;
            }
        }
        return cnt;
    }
}