import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int answer = 0;
        //이름 별 선물 받은 수 
        HashMap<String, Integer> nameToGiftCount = new HashMap<>();
        
        //"친구A 친구B" 관계의 수
        HashMap<String, Integer> giftRelationToCount = new HashMap<>();
        
        //이름별 선물 지수
        HashMap<String, Integer> nameToGiftIndex = new HashMap<>();

        for (String gift : gifts) {
            giftRelationToCount.put(gift, giftRelationToCount.getOrDefault(gift, 0) + 1);
            
            String[] giftRelationship = gift.split(" ");
            nameToGiftIndex.put(giftRelationship[0], nameToGiftIndex.getOrDefault(giftRelationship[0], 0) + 1);
            nameToGiftIndex.put(giftRelationship[1], nameToGiftIndex.getOrDefault(giftRelationship[1], 0) - 1);
        }
        
        for (String a : friends) {
            for (String b : friends) {
                //equals 비교만하면 "A B"와 "B A"를 각각 계산하므로, 둘 중 하나만 비교하도록 조건 추가
                if (a.equals(b) || a.compareTo(b) > 0) {
                    continue;
                }
                String aToB = a + " " + b;
                int aToBCount = giftRelationToCount.getOrDefault(aToB, 0);

                String bToA = b + " " + a;
                int bToACount = giftRelationToCount.getOrDefault(bToA, 0);
                
                String receiver;
                if (aToBCount > bToACount) {
                    receiver = a;
                } else if (aToBCount < bToACount) {
                    receiver = b;
                } else {
                    //friends에는 있지만 gifts에는 없는 경우 존재함(tc 17,20)
                    int giftIndexOfA = nameToGiftIndex.getOrDefault(a,0);
                    int giftIndexOfB = nameToGiftIndex.getOrDefault(b,0);
                    
                    if (giftIndexOfA > giftIndexOfB) {
                        receiver = a;
                    } else if (giftIndexOfB > giftIndexOfA) {
                        receiver = b;
                    } else {
                        continue;
                    }
                }
                nameToGiftCount.put(receiver, nameToGiftCount.getOrDefault(receiver, 0) + 1);
            }
        }

        for (String receiver : nameToGiftCount.keySet()) {
            if (nameToGiftCount.get(receiver) > answer) {
                answer = nameToGiftCount.get(receiver);
            }
        }
        return answer;
    }
}
