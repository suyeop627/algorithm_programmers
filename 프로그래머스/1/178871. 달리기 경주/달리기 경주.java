import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> nameToRank = new HashMap<>();
        for(int i=0; i< players.length; i++){
            nameToRank.put(players[i], i);
        }
        for(String calling : callings){
            int calledPlayerIndex = nameToRank.get(calling);
            
            String frontPlayer = players[calledPlayerIndex -1];
            
            nameToRank.put(calling, calledPlayerIndex-1);
            nameToRank.put(frontPlayer, nameToRank.get(frontPlayer) +1);
            
            players[calledPlayerIndex] = frontPlayer;
            players[calledPlayerIndex-1] = calling;
        }

        return players;
    }
}