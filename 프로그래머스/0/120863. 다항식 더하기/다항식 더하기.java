import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer="";
        String[] arr = polynomial.split(" ");
        int x = Arrays.stream(arr)
                .filter(str -> str.contains("x"))
                .mapToInt(str -> {
                    String num = str.replace("x", "");
                    return num.equals("") ? 1 : Integer.parseInt(num);
                })
                .sum();
        
        int num = Arrays.stream(arr)
                .filter(str -> !str.contains("x") && !str.equals("+"))
                .mapToInt(Integer::parseInt)
                .sum();
        
        
        
        if(x > 0){
           if(x == 1){
                answer += "x";
            }else{
                answer += x + "x";
            }
        }
        
        if(num > 0){
            if(answer.length() > 0){
                answer+= " + ";
            }
            answer+=num;
        }
        return answer;
    }
}