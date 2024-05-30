import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        StringBuffer suffix = new StringBuffer();
        for(int i = my_string.length()-1; i>=0; i--){
            suffix.insert(0,my_string.charAt(i));
            
            list.add(suffix.toString());
        }
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}