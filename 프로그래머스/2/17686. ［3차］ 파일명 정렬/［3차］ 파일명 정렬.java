import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
            .sorted((file1, file2) -> {
                FileName part1 = splitFileName(file1);
                FileName part2 = splitFileName(file2);

                //head 비교
                int headCompare = part1.head.compareToIgnoreCase(part2.head);
                if (headCompare != 0) {
                    return headCompare;
                }
                return part1.number < part2.number ? -1 : part1.number == part2.number ? 0 : 1;
            })
            .toArray(String[]::new);
    }

    // 파일명에서 HEAD, NUMBER, TAIL을 분리하는 메소드
    private FileName splitFileName(String file) {
        int headLength = 0;
        //숫자 나오기 전까지
        while (headLength < file.length() && !Character.isDigit(file.charAt(headLength))) {
            headLength++;
        }
        String head = file.substring(0, headLength);

        //headLength ~ 마지막 숫자까지
        int numberLength = headLength;
        while (numberLength < file.length() && Character.isDigit(file.charAt(numberLength))) {
            numberLength++;
        }
        int number = Integer.parseInt(file.substring(headLength, numberLength));

        return new FileName(head, number);
    }

    class FileName {
        String head;
        int number;

        FileName(String head, int number) {
            this.head = head;
            this.number = number;           
        }
    }
}