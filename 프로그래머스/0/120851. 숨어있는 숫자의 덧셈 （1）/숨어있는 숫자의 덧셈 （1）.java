class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i =0; i<my_string.length(); i++){
            try{
                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
            }catch(Exception e){
                continue;
            }
        }
        return answer;
    }
}