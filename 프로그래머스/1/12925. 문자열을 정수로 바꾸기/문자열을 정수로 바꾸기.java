class Solution {
    public int solution(String s) {
        char first = s.charAt(0);
        if(!Character.isDigit(first)){
            s = s.substring(1);
            if(first=='-'){
                return Integer.parseInt(s) * (-1);
            }
        }
        return Integer.parseInt(s);
    }
}