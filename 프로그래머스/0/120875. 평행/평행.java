class Solution {
    public int solution(int[][] dots) {
        
        if(isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if(isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if(isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d){
        //(y2 - y1) / (x2 - x1)
        return (double)(a[1]-b[1]) / (a[0] -b[0]) 
            == (double)(c[1]-d[1]) / (c[0] -d[0]);
    }
}