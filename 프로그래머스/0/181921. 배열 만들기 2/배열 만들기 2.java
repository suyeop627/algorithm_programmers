import java.util.ArrayList;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> result = new ArrayList<>();

        dfs(l, r, 5, result);
        
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        
        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    private void dfs(int l, int r, int cur, ArrayList<Integer> list) {
        if (cur > r) return;
        
        if (cur >= l) list.add(cur);
        
        dfs(l, r, cur * 10, list);
        dfs(l, r, cur * 10 + 5, list);
    }
}