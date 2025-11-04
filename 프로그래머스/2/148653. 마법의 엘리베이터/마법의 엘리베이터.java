class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){

            int num = storey % 10;
            if(num > 5){
                answer = answer +10 -num;
                storey = storey +10 -num;
            }else if(num < 5){
                    answer = answer +num;
                    storey = storey -num;    
            }else{
                if((storey/10) % 10 >= 5){
                    answer = answer +10 -num;
                    storey = storey +10 -num;
                }else{
                    answer = answer +num;
                    storey = storey -num;    
                }
            }
            storey /= 10;
            
        }

        return answer;
    }
}