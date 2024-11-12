import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        
        char[] resultCharArray = dartResult.toCharArray();
        int[] points = new int[3];
        int pointIndex = 0;

        for(int i = 0; i< resultCharArray.length; i++){
            char letter = resultCharArray[i];
            
            if(Character.isDigit(letter)){
                if(i < resultCharArray.length-1 && letter == '1' && resultCharArray[i+1]=='0'){
                    points[pointIndex] = 10;
                    i++;
                }else{
                    points[pointIndex] = (int) letter-'0';
                }

            }else if(letter >= 'D' && letter <= 'T'){
                points[pointIndex] = adjustPower(points[pointIndex], letter);
            
            }else{
                adjustOption(points, pointIndex, letter);
            }

            if(i < resultCharArray.length-1 && Character.isDigit(resultCharArray[i+1])){
                pointIndex++;
            }
        }
        return Arrays.stream(points).sum();
    }

    private int adjustPower(int point, char letter){
        switch(letter){
            case 'S' :
                return point;
            case 'D' :
                return (int)Math.pow(point, 2);
            default :
                return (int)Math.pow(point, 3);
        }
    }
    
    private void adjustOption(int[] points, int pointIndex, char letter){
        if (letter == '*') {
            points[pointIndex] *= 2;
            if (pointIndex > 0) {
                points[pointIndex - 1] *= 2;
            }
        } else {
            points[pointIndex] *= -1;
        }
    }
}