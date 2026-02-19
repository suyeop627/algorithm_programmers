import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        Arrays.stream(X.split(""))
            .forEach(x -> xArr[Integer.parseInt(x)]++);
        Arrays.stream(Y.split(""))
            .forEach(y -> yArr[Integer.parseInt(y)]++);
        
        
        int[] result = new int[10];
        for(int i = 0; i < 10; i++){
            result[i] = Math.min(xArr[i], yArr[i]);
        }
        
        //Arrays.stream(xArr).forEach(System.out::println);
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >=0; i--){
            sb.append(String.valueOf(i).repeat(result[i]));
        }
        
        if(sb.length() ==0){
            return "-1";
        }
        
        String answer = sb.toString();
        boolean allZero = true;
        for(char c : answer.toCharArray()){
            if(c != '0') allZero = false;
        }
        
        
        if(allZero){
            return "0";
        }
        
        return answer;
    }
}