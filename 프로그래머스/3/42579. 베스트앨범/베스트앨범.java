import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Play>> genreToPlay = new HashMap<>();
        Map<String, Integer> genreToPlayCountSum = new HashMap<>();
        
        for(int i = 0; i< genres.length; i++){
            List<Play> list = genreToPlay.getOrDefault(genres[i], new ArrayList<Play>());
            list.add(new Play(plays[i], i));
            genreToPlay.put(genres[i], list);
            
            genreToPlayCountSum.put(
                genres[i], 
                genreToPlayCountSum.getOrDefault(genres[i], 0) +plays[i]);
        }
        
        List<Integer> ansList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<String> sortedGenres = new ArrayList<>(genreToPlayCountSum.keySet());
        sortedGenres.sort((g1, g2) -> genreToPlayCountSum.get(g2) - genreToPlayCountSum.get(g1));
        
        for(String g : sortedGenres){
            if(set.contains(g)) continue;
            List<Play> list = genreToPlay.get(g);
            Collections.sort(list);
            ansList.add(list.get(0).index);
            
            if(list.size() >= 2){
                ansList.add(list.get(1).index);
            }
            set.add(g);
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
    class Play implements Comparable<Play>{
        int playCount;
        int index;
        Play(int playCount, int index){
            this.playCount = playCount;
            this.index = index;
        }
        @Override
        public int compareTo(Play p){
            if(this.playCount == p.playCount){
                return this.index - p.index;
            }else{
                return p.playCount - this.playCount;
            }
        }
    }
}