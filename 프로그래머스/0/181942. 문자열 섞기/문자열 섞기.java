class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int index = 0;
        while(index < str1Arr.length){
            answer+=str1Arr[index];
            answer+=str2Arr[index];
            index++;
        }
        return answer;
    }
}