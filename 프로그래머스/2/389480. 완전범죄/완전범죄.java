import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private int minATrace = 120;
    
    private Set<String> visited = new HashSet<>();
    
    public int solution(int[][] info, int n, int m) {
        //큰거부터 훔치도록(시간초과 개선)
        Arrays.sort(info, (a, b) -> b[0] - a[0]);
        
        steal(info, n, m, 0, 0, 0);
        
        return minATrace == 120 ? -1 : minATrace;
    }
    
    private void steal(int[][] info, int n, int m, int sumOfATrace, int sumOfBTrace , int index){
        //둘중 하나 이상 걸림
        if(sumOfATrace >= n || sumOfBTrace >= m){
            return;
        }
        //이미 최소 흔적을 넘긴 경우 종료(시간초과 개선)
        if(sumOfATrace >= minATrace){
            return;
        }
        //index-A흔적합-B흔적합 중간 결과값 저장(시간초과 개선)
        String partialResult = String.format("%d|%d|%d", index,sumOfATrace, sumOfBTrace);
        if(visited.contains(partialResult)){
            return;
        }
        visited.add(partialResult);
        
        //전부 훔치면 종료
        if(index == info.length){
            minATrace = Math.min(sumOfATrace, minATrace);
            return;
        }
        
        int nextIndex = index+1;
        //A 훔침
        steal(info, n, m, sumOfATrace+info[index][0], sumOfBTrace, nextIndex);
        
        //B 훔침
        steal(info, n, m, sumOfATrace, sumOfBTrace+info[index][1], nextIndex);
    }
}