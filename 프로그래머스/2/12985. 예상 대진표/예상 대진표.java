class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int leftSide = a;
        int rightSide = b;
        
        if(a > b){
            leftSide = b;
            rightSide = a;
        }
        
        while(!(rightSide == leftSide + 1 && rightSide %2==0)){
            answer++;
            rightSide = rightSide % 2 == 0 ? rightSide / 2 : (rightSide + 1) / 2;
            leftSide = leftSide % 2 == 0 ? leftSide / 2 : (leftSide + 1) / 2;
        }
        
        return answer;
    }
}