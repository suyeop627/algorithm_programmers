class Solution {
    public String solution(String code) {
        String answer = "";
        boolean isModeOn = false;
        String[] codes = code.split("");
        int idx = 0;
        for(String c : codes){
            switch(c){
                case "1":
                    isModeOn = !isModeOn;
                    break;
                default:
                    if(!isModeOn && idx %2==0){
                        answer+=c;
                    }
                    if(isModeOn && idx %2 ==1){
                        answer+=c;
                    }
            }
            idx++;
        }
        return answer.isEmpty() ? "EMPTY" : answer;
    }
}