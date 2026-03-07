class Solution {
    public int solution(int n) {
        int answer = 0;
        int limit = (int) Math.sqrt(n);
        for(int i = 1; i <=limit; i++){
            for(int j = n; j >=limit; j--){
                if(i*j==n){
                    System.out.println("i = " + i + ", j = " + j);
                    answer++;
                }
            }
        }   
        answer*=2;
        if(limit * limit == n){
            answer--;
        }
        return answer;
    }
}