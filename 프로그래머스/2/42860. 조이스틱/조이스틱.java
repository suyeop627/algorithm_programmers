public class Solution {
    public int solution(String name) {
        
        int nameLength = name.length(); 
        int minHorizontalMoves = nameLength - 1;
        int minVerticalMoves = 0;
        
        for (int i = 0; i < nameLength; i++) {
            minVerticalMoves += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int nextIndex = i + 1;
            
            while (nextIndex < nameLength && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            
            int goBackAndComeFromEnd = i + i + nameLength - nextIndex;
            int goForwardAndComeFromStart = (nameLength - nextIndex) + (nameLength - nextIndex) + i;
            
            int moves = Math.min(goBackAndComeFromEnd, goForwardAndComeFromStart);
            
            minHorizontalMoves = Math.min(minHorizontalMoves, moves);
        }
        
        return minVerticalMoves + minHorizontalMoves;
    }
}