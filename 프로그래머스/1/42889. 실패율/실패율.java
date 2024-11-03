import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //도달 유저 수
        int[] reachedCount = new int[N + 2];
        //도달했으나 클리어 하지 못한 수
        int[] notClearedCount = new int[N + 2];

        for (int stage : stages) {
            if (stage <= N) {
                notClearedCount[stage]++;
            }
            for (int i = 1; i < stage; i++) {
                reachedCount[i]++;
            }
        }
        
        List<Stage> stageList = new ArrayList<>();
        
        //스테이지별 스테이지번호, 실패율 저장
        IntStream.rangeClosed(1, N)
            .forEach(n -> 
                     stageList.add(new Stage(n, 
                                            reachedCount[n] + notClearedCount[n] > 0 
                                            ? (double) notClearedCount[n] / reachedCount[n]
                                            : 0.0)));

        return stageList.stream()
            .sorted(Comparator.comparingDouble(Stage::getFailRatio)
                    .reversed()
                    .thenComparing(Stage::getStageNo))
            .mapToInt(Stage::getStageNo)
            .toArray();
    }
}

class Stage {
    int stageNo;
    double failRatio;

    public Stage(int stageNo, double failRatio) {
        this.stageNo = stageNo;
        this.failRatio = failRatio;
    }

    public int getStageNo() {
        return stageNo;
    }

    public double getFailRatio() {
        return failRatio;
    }
    
    
    
}
