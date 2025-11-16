import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int colIndex = col - 1;

        Arrays.sort(data, (a, b) -> {
            if (a[colIndex] != b[colIndex]) {
                return Integer.compare(a[colIndex], b[colIndex]); // col 기준 오름차순
            }
            return Integer.compare(b[0], a[0]);     // dtaa[i][0] 기준 내림차순
        });


        int[] remainders = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            int rowIndex = i +1;
            remainders[i] = Arrays.stream(data[i]).map(num -> num % rowIndex).sum();
        }
        //Bitwise XOR : 두 숫자의 각 비트를 비교해서 “다르면 1, 같으면 0”
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            answer ^= remainders[i];
        }

        return answer;
    }
}