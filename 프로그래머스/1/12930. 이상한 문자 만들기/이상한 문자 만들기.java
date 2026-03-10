class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cArr = s.toCharArray();
        int index = 0;
        for(int i = 0; i< s.length(); i++){
            if(cArr[i] == ' ') {
                index = 0;
                continue;
            }
            if(index%2 ==0 && Character.isLowerCase(cArr[i])){
                cArr[i] =(char) (cArr[i] -'a' + 'A');
            }else if(index%2==1 && Character.isUpperCase(cArr[i])){
                cArr[i] = (char)(cArr[i] -'A' + 'a');
            }
            index++;
        }
        answer  = String.valueOf(cArr);
        return answer;
    }
}