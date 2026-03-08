class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int count = 0;
        int i = 0;
        while(count <k){
            answer = numbers[i%numbers.length];
            count++;
            i+=2;
        }
        return answer;
    }
}