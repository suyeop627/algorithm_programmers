import java.util.List;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> notFinishedList = new ArrayList<>();
        for(int i = 0; i<finished.length; i++){
            if(!finished[i]){
                notFinishedList.add(todo_list[i]);
            }
        }
        return notFinishedList.toArray(String[]::new);
    }
}