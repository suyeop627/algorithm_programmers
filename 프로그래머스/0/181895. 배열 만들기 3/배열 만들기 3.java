import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1]-intervals[0][0]+intervals[1][1]-intervals[1][0]+2];

        int[] eachIntervalArray1 = getEachIntervalArray(intervals[0][0], intervals[0][1]);
        int[] eachIntervalArray2 = getEachIntervalArray(intervals[1][0], intervals[1][1]);
        
        int[] mergedArray = 
            IntStream
            .concat(IntStream.of(eachIntervalArray1), IntStream.of(eachIntervalArray2)).toArray();
        
        for(int i = 0; i<mergedArray.length; i++){
            answer[i] = arr[mergedArray[i]];
        }
        
        return answer;
    }
    private int[] getEachIntervalArray(int start, int end){
        int[] eachInterval = new int[end-start+1];
        int index = 0;
        for(int i = start; i<=end; i++){
            eachInterval[index++] = i;
        }

        return eachInterval;
    }
}