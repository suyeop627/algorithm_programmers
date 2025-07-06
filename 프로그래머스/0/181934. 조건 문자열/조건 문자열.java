class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean isCorrect = false;
        switch(ineq+eq){
            case ">=":
                isCorrect= n>=m;
                break;
            case "<=":
                isCorrect= n<=m;
                break;
            case ">!":
                isCorrect= n>m;
                break;
            default:
                isCorrect = n<m;
        }
        
        return isCorrect ? 1 : 0;
    }
}