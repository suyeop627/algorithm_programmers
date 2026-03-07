class Solution {
    public int solution(int num, int k) {
        String n = String.valueOf(num);
        return n.contains(String.valueOf(k)) ? n.indexOf(String.valueOf(k))+1 : -1;
    }
}