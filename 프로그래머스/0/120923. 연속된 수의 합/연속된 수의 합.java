class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 0;
        int sum = 0;
        for(int i = 0; i< num; i++){
            sum+=start+i;;
        }
        while(sum != total){
            if(sum > total){
                sum-=num;
                start--;
            }else{
                sum+=num;
                start++;
            }
        }
        
        for(int i = 0; i < num; i++){
            answer[i] = start+i;
        }
        return answer;
    }
}