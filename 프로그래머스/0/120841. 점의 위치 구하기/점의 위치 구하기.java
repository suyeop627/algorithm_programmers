class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0];
        int y = dot[1];
        if(x*y > 0){
            if(x > 0){
                return 1;
            }else{
                return 3;
            }
        }else{
            if(x > 0){
                return 4;
            }else{
                return 2;
            }
        }
    }
}