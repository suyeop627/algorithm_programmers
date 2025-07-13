class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int attackIndex = 0;
        int maxHealth = health;
        
        int bandageActivatedTime = 0;
        for(int time = 1; time <= attacks[attacks.length-1][0]; time++){
            bandageActivatedTime++;
            if(attacks[attackIndex][0] == time){
                health -= attacks[attackIndex++][1];
                if(health <= 0) return -1;
                
                bandageActivatedTime = 0;
                continue;
            }
            health = Math.min(maxHealth, health + bandage[1]);
            if(bandageActivatedTime == bandage[0]){
                health = Math.min(maxHealth, health+bandage[2]);
                bandageActivatedTime = 0;
            }
        }
        return health;
    }
}