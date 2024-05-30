import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        String  suffix = "";
        for(int i = my_string.length()-1; i>=0; i--){
            suffix =my_string.charAt(i)+suffix;
            list.add(suffix);
        }
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}