class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int n : num_list){
            while(n != 1){
                if(n % 2 == 0){
                    n/=2;
                    answer++;
                } 
                else n-=1;
            }
        }
        return answer;
    }
}