class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        /*
        sides = a,b(a > b)
        else = c
        
        if max=a
            a < c+b
        if max=c
            c < a+b
            
         a-b < c < b+a
        */
        int a = Math.max(sides[0], sides[1]);
        int b = Math.min(sides[0], sides[1]);
        
        return (a+b) - (a-b) -1;
    }
}