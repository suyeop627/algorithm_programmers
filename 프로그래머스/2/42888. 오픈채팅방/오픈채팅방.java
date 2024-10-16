import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    Map<String, String> userMap = new HashMap<>();

    public String[] solution(String[] record) {
        
        String[][] seperatedRecords = Arrays.stream(record)
                                            .map(s->s.split(" "))
                                            .toArray(String[][]::new);
        
        for(String[] seperatedRecord : seperatedRecords){
            if(seperatedRecord[0].charAt(0) != 'L'){
                userMap.put(seperatedRecord[1], seperatedRecord[2]);
            }
        }
        
        return Arrays.stream(seperatedRecords)
            .filter(r->!r[0].startsWith("C"))
            .map(this::convertLog)
            .toArray(String[]::new);
    }
    
    private String convertLog(String[] engLog){
        String userName = userMap.get(engLog[1]);
        
        switch(engLog[0].charAt(0)){
            case 'E' :
                return userMap.get(engLog[1])+"님이 들어왔습니다.";
            case 'L' :
                return userMap.get(engLog[1])+"님이 나갔습니다.";
            default :
                return "";
        }
    }
}