class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i =0; i < s.length(); i++){
            String tmp = s.substring(0, i);
            if(tmp.indexOf(s.charAt(i)) != -1){
                answer[i] = i - tmp.lastIndexOf(s.charAt(i));
            }else{
                answer[i] = -1;
            }
            
        }
        return answer;
    }
}