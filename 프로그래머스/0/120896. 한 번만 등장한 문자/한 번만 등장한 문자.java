class Solution {
    public String solution(String s) {
        String answer="";
        int[] check = new int[26];
        for(char c : s.toCharArray()){
            check[c - 'a']++;
        }
        for(int i = 0; i < check.length; i++){
            if(check[i] == 1){
                answer+=(char)('a'+i);
            }
        }
        return answer;
    }
}