import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;

        int[] doubledArr = new int[n*2];
        for (int i=0; i <n; i++) {
            doubledArr[i] = elements[i];
            doubledArr[i+n] = elements[i];
            
        }
        
        Set<Integer> sums = new HashSet<>();

        for (int subLength =1; subLength <= n; subLength++) {
            int subSum = 0;
            for (int i = 0; i < subLength; i++) {
                subSum += doubledArr[i];
            }
            sums.add(subSum);

            for (int start = 1; start < n; start++) {
                subSum -= doubledArr[start-1];
                subSum += doubledArr[start +subLength - 1];
                sums.add(subSum);
            }
        }

        return sums.size();
    }
}
