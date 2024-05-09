class Solution {
    public int[] solution(String myString) {
        
        String[] arrayDividedByX = myString.split("x",-1);
        int[] answer = new int[arrayDividedByX.length];
        for(int i = 0; i<arrayDividedByX.length; i++){
            answer[i] = arrayDividedByX[i].length();
        }
        return answer;
    }
}