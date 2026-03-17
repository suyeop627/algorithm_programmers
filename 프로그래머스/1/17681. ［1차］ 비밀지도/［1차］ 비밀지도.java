import java.util.*;
import java.lang.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] strArr1 = Arrays.stream(arr1).mapToObj(Integer::toBinaryString)
            .map(s -> String.format("%" + n + "s", s).replace(' ', '0'))
            .toArray(String[]::new);
        String[] strArr2 = Arrays.stream(arr2).mapToObj(Integer::toBinaryString)
            .map(s -> String.format("%" + n + "s", s).replace(' ', '0'))
            .toArray(String[]::new);
        
        System.out.println(Arrays.toString(strArr1));
        
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j< n; j++){
                if(strArr1[i].charAt(j) == '1' || strArr2[i].charAt(j) == '1'){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}