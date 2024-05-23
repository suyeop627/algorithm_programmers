class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] dividedBinomial = binomial.split(" ");
        int num1 = Integer.parseInt(dividedBinomial[0]);
        int num2 = Integer.parseInt(dividedBinomial[2]);
        switch(dividedBinomial[1]){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            default:
                return num1 * num2;
        }
    } 
}