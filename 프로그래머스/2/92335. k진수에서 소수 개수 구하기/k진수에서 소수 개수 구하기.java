import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kJinsu = toKJinsu(n,k);
        String[] arr = toKJinsu(n,k).split("0");
        
        for(String s : arr){
             if(s.length() > 0 
                && !s.equals("1") 
                && isPrimeNumber(Long.parseLong(s))){
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isPrimeNumber(long n){
        for(long i = 2; i *i <=n; i++){
            if(n %i ==0) return false;
        }
        return true;
    }
    
    private String toKJinsu(int number, int k){
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            sb.insert(0, number%k);
            number/=k;
        }
        return sb.toString();
    }
}