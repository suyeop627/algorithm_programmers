import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] checkArr = new int[n+1];
        for(int i = 2; i <= n; i++){
            if(checkArr[i] ==0){
                for(int j = i+i; j <=n; j+=i){
                    checkArr[j]=1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <=n; i++){
            if(checkArr[i]==0 && n %i==0){
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}