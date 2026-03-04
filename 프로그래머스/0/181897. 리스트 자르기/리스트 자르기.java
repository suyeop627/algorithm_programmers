import java.util.Arrays;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch(n){
            case 1 -> {return Arrays.copyOfRange(num_list,0, slicer[1]+1);}
            case 2 -> {return Arrays.copyOfRange(num_list,slicer[0], num_list.length);}
            case 3 -> {return Arrays.copyOfRange(num_list,slicer[0], slicer[1]+1);}
            default -> {
                int start = slicer[0];
                int end = slicer[1];
                int step = slicer[2];
                
                
                int[] answer = new int[(end-start)/step+1];
                int idx = 0;
                for(int i = start; i <= end; i+=step){
                    answer[idx]=num_list[i];
                    idx++;
                }
                return answer;
            }
        }
    }
}