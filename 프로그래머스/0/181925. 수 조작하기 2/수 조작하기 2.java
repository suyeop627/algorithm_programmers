class Solution {
    public String solution(int[] numLog) {
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<numLog.length; i++){
            int num = numLog[i]-numLog[i-1];
            switch(num){
                    case 1->sb.append("w");
                    case -1 ->sb.append("s");
                    case 10 ->sb.append("d");
                    case -10 ->sb.append("a");
            }
        }
        return sb.toString();
    }
}