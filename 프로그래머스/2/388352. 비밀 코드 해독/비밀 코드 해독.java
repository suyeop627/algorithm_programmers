import java.util.*;

class Solution {    
    private final List<int[]> codeCandidates = new ArrayList<>();

    public int solution(int n, int[][] q, int[] ans) {

        findCandidates(n, 1, 0, new int[5], q[0], ans[0]);
        
        for (int i = 1; i < q.length; i++) {
            Iterator<int[]> iter = codeCandidates.iterator();
            while (iter.hasNext()) {
                int[] candidate = iter.next();
                if (countCommon(candidate, q[i]) != ans[i]) {
                    iter.remove();
                }
            }
        }
        return codeCandidates.size();
    }

    private void findCandidates(int range, int start, int index, 
                                int[] current, int[] q, int ans) {
        //System.out.println(Arrays.toString(current));
        if (index == 5 ){
            if(countCommon(current, q) == ans)
                codeCandidates.add(Arrays.copyOf(current, 5));
            return;
        }
        for (int i = start; i <= range; i++) {
            current[index] = i;
            findCandidates(range, i + 1, index + 1, current, q, ans);
        }
    }

    private int countCommon(int[] current, int[] q) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : q) set.add(i);

        for (int i : current) {
            if (set.contains(i)) count++;
        }
        return count;
    }
}
