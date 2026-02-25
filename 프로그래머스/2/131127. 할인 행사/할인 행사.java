import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> toPurchase = new HashMap<>();
        for(int i =  0; i < want.length; i++){
            toPurchase.put(want[i], number[i]);
        }
        
        
        
        Map<String, Integer> itemToNumber = new HashMap<>();
        
        for(int i =0; i < 10; i++){
            itemToNumber.put(
                discount[i], 
                itemToNumber.getOrDefault(discount[i], 0) +1
            );
        }
        increaseAnswerIfRegistable(itemToNumber, toPurchase);
        
        for(int i =10; i < discount.length; i++){
            String currentKey = discount[i-10];
            
            if(itemToNumber.containsKey(currentKey)){
                int countAfterReduction = itemToNumber.get(currentKey) -1;
                if(countAfterReduction > 0){
                    itemToNumber.put(currentKey, countAfterReduction);    
                }else{
                    itemToNumber.remove(currentKey);
                }
            }

            itemToNumber.put(
                discount[i], 
                itemToNumber.getOrDefault(discount[i], 0) + 1
            );
            
        increaseAnswerIfRegistable(itemToNumber, toPurchase);
       }
        
        return answer;
    }
    
    public void increaseAnswerIfRegistable(Map<String, Integer> itemToNumber, 
                                           Map<String, Integer> toPurchase){
        
        int tmp = 0;
        for(String item: toPurchase.keySet()) {
            if(toPurchase.get(item).equals(itemToNumber.get(item))){
                tmp++;
            }
        }
            
        if(tmp == itemToNumber.size()){
            answer++;
        }
    }
}