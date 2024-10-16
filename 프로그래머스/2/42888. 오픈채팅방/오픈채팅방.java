import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    Map<String, String> userMap = new HashMap<>();

    public String[] solution(String[] record) {
        
        String[][] separatedRecords = new String[record.length][];
        
        for (int i = 0; i < record.length; i++) {
            separatedRecords[i] = record[i].split(" ");
        }
        
        for(String[] separatedRecord : separatedRecords){
            if(separatedRecord[0].charAt(0) != 'L'){
                userMap.put(separatedRecord[1], separatedRecord[2]);
            }
        }
        
        return Arrays.stream(separatedRecords)
            .filter(r->!r[0].startsWith("C"))
            .map(this::convertLog)
            .toArray(String[]::new);
    }
    
    private String convertLog(String[] engLog){
        String userName = userMap.get(engLog[1]);
        
        switch(engLog[0].charAt(0)){
            case 'E' :
                return userName+"님이 들어왔습니다.";
            case 'L' :
                return userName+"님이 나갔습니다.";
            default :
                return "";
        }
    }
}