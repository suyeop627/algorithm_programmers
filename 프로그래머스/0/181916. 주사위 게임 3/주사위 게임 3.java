import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        int size = map.keySet().size();
        int answer = 0;
        
        switch(size){
            case 1 -> // 네 개 다 같음
                answer = 1111 * a;
                
            case 2 -> {
                // (3,1) 또는 (2,2)
                int x = 0, y = 0;
                for (int key : map.keySet()) {
                    if (map.get(key) == 3) {
                        // (3,1) 케이스
                        x = key;
                    } else if (map.get(key) == 1) {
                        y = key;
                    }
                }
                if (x != 0 && y != 0) {
                    // (3,1) 케이스 → (10 * x + y)^2
                    answer = (int)Math.pow(10 * x + y, 2);
                } else {
                    // (2,2) 케이스 → (x+y) * |x-y|
                    int[] nums = new int[2];
                    int idx = 0;
                    for (int key : map.keySet()) nums[idx++] = key;
                    answer = (nums[0] + nums[1]) * Math.abs(nums[0] - nums[1]);
                }
            }
            
            case 3 -> {
                // (2,1,1) 케이스
                int pair = 0, single1 = 0, single2 = 0;
                for (int key : map.keySet()) {
                    if (map.get(key) == 2) {
                        pair = key;
                    } else {
                        if (single1 == 0) single1 = key;
                        else single2 = key;
                    }
                }
                // 두 개 다른 숫자끼리 곱
                answer = single1 * single2;
            }
            
            case 4 -> // 네 개 다 다름 → 최소값
                answer = Math.min(Math.min(a, b), Math.min(c, d));
        }
        
        return answer;
    }
}
