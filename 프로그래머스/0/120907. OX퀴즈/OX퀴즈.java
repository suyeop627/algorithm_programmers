class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            
            int first = Integer.parseInt(arr[0]);
            String operator = arr[1];
            int second = Integer.parseInt(arr[2]);
            int calculated = Integer.parseInt(arr[4]);
            
            int result = operator.equals("+") ? first + second : first - second;
            
            answer[i] = (calculated == result) ? "O" : "X";
        }
        
        return answer;
    }
}