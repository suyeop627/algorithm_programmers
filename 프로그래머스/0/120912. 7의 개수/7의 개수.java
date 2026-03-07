class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i : array){
            char[] cArr = String.valueOf(i).toCharArray();
            for(char c : cArr){
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}