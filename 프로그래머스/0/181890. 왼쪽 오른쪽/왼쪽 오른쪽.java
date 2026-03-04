import java.util.Arrays;
class Solution {
    public String[] solution(String[] str_list) {
        int idx = -1;
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l") || str_list[i].equals("r")){
                idx = i;
                break;
            }
        }
        
        if(idx <0){
            return new String[0];
        }
        
        if(str_list[idx].equals("l")){
            return Arrays.copyOfRange(str_list, 0, idx);
        }
        
        return Arrays.copyOfRange(str_list,idx+1, str_list.length);
    }
}