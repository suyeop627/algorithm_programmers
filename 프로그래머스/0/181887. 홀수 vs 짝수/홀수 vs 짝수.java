class Solution {
    public int solution(int[] num_list) {
        int sumOfOddIndex = 0;
        int sumOfEvenIndex = 0;
        for(int i = 0; i<num_list.length; i++){
            if(i%2==0){
                sumOfOddIndex+=num_list[i];
            }else{
                sumOfEvenIndex+=num_list[i];
            }
        }
        
        return sumOfEvenIndex > sumOfOddIndex ? sumOfEvenIndex : sumOfOddIndex;
    }
}