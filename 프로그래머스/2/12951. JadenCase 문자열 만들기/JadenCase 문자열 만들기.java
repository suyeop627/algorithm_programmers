class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ",-1);

        for(String str : arr){
            if(str.length() == 0){
                answer += " ";
                continue;
            }

            str = str.toLowerCase();

            if(str.length() == 1){
                answer += str.toUpperCase();
            }else if(!Character.isDigit(str.charAt(0))){
                answer += str.substring(0,1).toUpperCase() + str.substring(1);
            }else{
                answer += str;
            }

            answer += " ";
        }

        return answer.substring(0, answer.length()-1);
    }
}