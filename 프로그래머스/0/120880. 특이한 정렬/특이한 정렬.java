class Solution {
    public int[] solution(int[] numlist, int n) {        
        
        for(int i = 0; i < numlist.length; i++){
            int idx =i;
            for(int j = i+1; j < numlist.length; j++){
                int diff1 = Math.abs(n - numlist[idx]);
                int diff2 = Math.abs(n - numlist[j]);
                if(diff1 > diff2|| (diff1==diff2 && numlist[idx] <numlist[j])){
                   idx = j;
                }
            }
            int tmp = numlist[i];
            numlist[i] = numlist[idx];
            numlist[idx] = tmp;
        }
        
        
        
        
        return numlist;
    }
}