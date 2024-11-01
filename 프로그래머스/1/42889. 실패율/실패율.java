import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] reachedCount = new int[N + 2];
        int[] notClearedCount = new int[N + 2];

        for (int stage : stages) {
            if (stage <= N) {
                reachedCount[stage]++;
            }
            for (int i = 1; i < stage; i++) {
                notClearedCount[i]++;
            }
        }

        List<Stage> stageList = new ArrayList<>();

        IntStream.rangeClosed(1, N)
            .forEach(n -> 
                     stageList.add(new Stage(n, 
                                        reachedCount[n] + notClearedCount[n] > 0 
                                        ? (double) reachedCount[n] / (reachedCount[n] + notClearedCount[n])
                                        : 0.0)));

        return stageList.stream()
            .sorted(Comparator.comparingDouble(Stage::getFailRatio).reversed()
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
