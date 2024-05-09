class Solution {
    public String[] solution(String[] strArr) {
        StringBuffer sb = new StringBuffer();
        for(String str : strArr){
            if(!str.contains("ad")){
                sb.append(str+",");
            }
        }
        return sb.toString().split(",");
    }
}