class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String b : babbling){
            b = b.replace("aya" ," ")
                .replace("ye", " ")
                .replace("woo", " ")
                .replace("ma"," ");
            if(b.trim().length() ==0){
                answer++;
            }
        }
        return answer;
    }
}