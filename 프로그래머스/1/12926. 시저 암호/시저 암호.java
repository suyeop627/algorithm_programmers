class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] cArr = s.toCharArray();
        for(int i =0; i < cArr.length; i++){
            if(cArr[i]==' ') continue;
            
            if(Character.isUpperCase(cArr[i])){
                cArr[i] = (char)((cArr[i]-'A' + n) %('Z'-'A'+1) + 'A');                
            }else{
                cArr[i] = (char)((cArr[i]-'a' + n) %('z'-'a'+1) + 'a');               
            }
        }
        answer = String.valueOf(cArr);
        return answer;
    }
}