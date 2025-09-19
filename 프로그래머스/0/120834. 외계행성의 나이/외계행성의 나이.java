class Solution {
    public String solution(int age) {
        String strAge = String.valueOf(age);
       StringBuilder sb = new StringBuilder();
        for(char charAge : strAge.toCharArray()){
           sb.append((char)(charAge-'0'+'a'));
        }
        return sb.toString();
    }
}