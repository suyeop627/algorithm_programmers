import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int n, String control) {
        
        Map<Character, Integer> controlToValueMap = new HashMap<>();
        controlToValueMap.put('w', 1);
        controlToValueMap.put('s', -1);
        controlToValueMap.put('d', 10);
        controlToValueMap.put('a', -10);
        
        for(int i =0; i<control.length(); i++){
            n+=controlToValueMap.get(control.charAt(i));
        }
        
        return n;
    }
}