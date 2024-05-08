class Solution {
    public String[] solution(String[] names) {
        String nameOfFirst="";
        for(int i =0; i<names.length; i+=5){
            nameOfFirst+=names[i]+",";
        }
        return nameOfFirst.split(",");
    }
}