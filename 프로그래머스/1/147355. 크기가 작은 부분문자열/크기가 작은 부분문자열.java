class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int lt = 0;
        int rt = p.length();
        
        while(rt <= t.length()){
            if(t.substring(lt, rt).compareTo(p)<=0){
                answer++;
            }
            lt++;
            rt++;
        }
        return answer;
    }
}