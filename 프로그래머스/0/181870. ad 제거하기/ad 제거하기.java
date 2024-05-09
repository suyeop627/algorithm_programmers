class Solution {
    public String[] solution(String[] strArr) {
        String strDividedComma = "";
        for(String str : strArr){
            if(!str.contains("ad")){
                strDividedComma+=str+",";
            }
        }
        return strDividedComma.split(",");
    }
}