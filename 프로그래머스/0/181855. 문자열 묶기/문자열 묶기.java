class Solution {
    public int solution(String[] strArr) {
        int[] countArr = new int[31];
        for(String s : strArr){
            countArr[s.length()]++;
        }
        int answer = 0;
        for(int count: countArr){
            if(count > answer){
                answer=count;
            }
        }
        return answer;
    }
}