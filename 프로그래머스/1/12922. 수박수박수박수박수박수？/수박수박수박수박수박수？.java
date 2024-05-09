class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i<=n; i++){
            sb.append(i%2==1 ? "수" : "박");
        }
        return sb.toString();
    }
}