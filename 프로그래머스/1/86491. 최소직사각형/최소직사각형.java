class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for(int[] size : sizes){
            int h = Math.max(size[0], size[1]);
            int w = Math.min(size[0], size[1]);
            if(maxWidth < w) maxWidth = w;
            if(maxHeight < h) maxHeight = h;
        }
        answer = maxWidth * maxHeight;
        return answer;
    }
}