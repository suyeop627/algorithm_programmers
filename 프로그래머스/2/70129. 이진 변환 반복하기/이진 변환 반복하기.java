class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            char[] cArr = s.toCharArray();
            for(char c : cArr){
                if(c=='0'){
                    answer[1]++;
                }
            }
            s = Integer.toBinaryString(s.replace("0", "").length());
            answer[0]++;
        }
        
        
        return answer;
    }
}