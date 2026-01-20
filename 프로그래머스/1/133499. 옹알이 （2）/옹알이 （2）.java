class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya","ye","woo","ma"};
        
        
        outerBabblingLoop:
        for(String b : babbling){
            while(b.length() > 0){
                boolean replaced=false;
                for(String word : words){
                    if(b.startsWith(word)){
                        if(b.startsWith(word + word)){
                            continue outerBabblingLoop;    
                        }
                        b = b.replaceFirst(word, "");    
                        replaced=true;
                        break;
                    }
                }
                if(!replaced){
                    continue outerBabblingLoop;    
                }
            }
          answer++;
        }
        return answer;
    }
}