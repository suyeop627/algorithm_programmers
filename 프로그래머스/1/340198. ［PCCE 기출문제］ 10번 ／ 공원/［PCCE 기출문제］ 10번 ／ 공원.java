import java.util.Arrays;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int maxLengthOfSide =  getMaxLengthOfSide(park);
        
        for(int mat : mats){
            if(mat <= maxLengthOfSide && answer < mat){
                answer = mat;
            }
        }
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    private int getMaxLengthOfSide(String[][] park) {
        int maxLength = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) {
                    int length = getLengthOfMaxSquare(park, i, j, 1);
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
    
    
    private int getLengthOfMaxSquare(String[][] park, int i, int j, int length){
        if (i + length > park.length || j + length > park[0].length) {
            return length-1;
        }
        
        for(int rowIndex =i; rowIndex<length +i; rowIndex++){
            for(int colIndex =j; colIndex<length+j; colIndex++){
                if(!park[rowIndex][colIndex].equals("-1")){
                    return length-1;
                }   
            }   
        }
        
        return getLengthOfMaxSquare(park, i, j, length+1);
    }
    
}