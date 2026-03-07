class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 %d에 있다";
        int idx = 0;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
            }
        }
        return String.format(answer, idx);
    }
}