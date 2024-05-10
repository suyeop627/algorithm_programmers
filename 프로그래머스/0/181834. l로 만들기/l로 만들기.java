class Solution {
    public String solution(String myString) {
        StringBuffer sb = new StringBuffer();
        for(char ch : myString.toCharArray()){
            if(ch<'l'){
                sb.append('l');
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}