import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private int minTraceA = 120;

    private Set<String> stealState = new HashSet<>();

    public int solution(int[][] info, int n, int m) {
        //큰거부터 훔치도록(시간초과 개선)
        Arrays.sort(info, (a, b) -> b[0] - a[0]);

        steal(info, n, m, 0, 0, 0);

        return minTraceA == 120 ? -1 : minTraceA;
    }

    private void steal(int[][] traceInfo, int traceLimitA, int traceLimitB, 
                       int sumOfTraceA, int sumOfTraceB , int itemIndex){
        //둘중 하나 이상 걸림
        if(sumOfTraceA >= traceLimitA || sumOfTraceB >= traceLimitB){
            return;
        }
        //이미 최소 흔적을 넘긴 경우 종료(시간초과 개선)
        if(sumOfTraceA >= minTraceA){
            return;
        }
        //index-A흔적합-B흔적합 중간 결과값 저장(시간초과 개선)
        String currentState = String.format("%d|%d|%d", itemIndex,sumOfTraceA, sumOfTraceB);
        if(stealState.contains(currentState)){
            return;
        }
        stealState.add(currentState);

        //전부 훔치면 종료
        if(itemIndex == traceInfo.length){
            minTraceA = sumOfTraceA;
            return;
        }

        int nextItemIndex = itemIndex+1;
        //A 훔침
        steal(traceInfo, traceLimitA, traceLimitB, sumOfTraceA+traceInfo[itemIndex][0], sumOfTraceB, nextItemIndex);

        //B 훔침
        steal(traceInfo, traceLimitA, traceLimitB, sumOfTraceA, sumOfTraceB+traceInfo[itemIndex][1], nextItemIndex);
    }
}