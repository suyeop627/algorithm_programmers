class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        for(int i = 0; i< answer.length; i++){
            answer[i] = -1;
        }
        int[] checkArr = new int[100_000];
        int idx = 0;
        for(int i : arr){
            if(checkArr[i] > 0){
                continue;
            }
            
            answer[idx] = i;
            idx++;
            checkArr[i]++;
            if(idx == answer.length){
                break;
            }
        }
        return answer;
    }
}