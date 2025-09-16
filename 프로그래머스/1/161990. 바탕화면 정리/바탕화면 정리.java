class Solution {
    public int[] solution(String[] wallpaper) {
          
        int[] answer = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE, -1,-1};
        
        for(int i = 0; i < wallpaper.length; i++){
            if(wallpaper[i].contains("#")){
                answer[0] = Math.min(answer[0], i);//lux
                answer[1] = Math.min(answer[1], wallpaper[i].indexOf("#"));//luy
                //파일을 감싸야 해서 +1
                answer[2] = Math.max(answer[2], i + 1);//rdx
                answer[3] = Math.max(answer[3], wallpaper[i].lastIndexOf("#") + 1);//rdy
            }
        }
        return answer;
    }
}