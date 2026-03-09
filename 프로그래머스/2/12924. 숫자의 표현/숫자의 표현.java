class Solution {
    public int solution(int n) {
        int answer = 0;
        int lt =1;
        int rt = 1;
        int sum = 1;
        while(rt <= n){
            if(sum < n){
                rt++;
                sum+=rt;
            }else if(sum > n){
                sum-=lt;
                lt++;
            }else{
                answer++;
                rt++;
                sum = sum -lt + rt;
                lt++;
            }
        }
        return answer;
    }
}