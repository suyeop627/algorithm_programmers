import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    Map<String, String> userMap = new HashMap<>();

    public String[] solution(String[] record) {
        
        for(String r : record){
            String[] separatedRecord = r.split(" ");
            
            String action = separatedRecord[0];
            String userId = separatedRecord[1];
            
            if(!action.equals("Leave")){
                String userName = separatedRecord[2];
                userMap.put(userId, userName);
            }
        }
        
        return Arrays.stream(record)
            .map(r->r.split(" "))
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