import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameToYearning = new HashMap<>();
        for(int i = 0; i< name.length; i++){
            nameToYearning.put(name[i], yearning[i]);
        }
        int index = 0;
        for(String[] models : photo){
            int points = 0;
            for(String model : models){
                points += nameToYearning.getOrDefault(model, 0);
            }
            answer[index++] = points;
        }
        return answer;
    }
}