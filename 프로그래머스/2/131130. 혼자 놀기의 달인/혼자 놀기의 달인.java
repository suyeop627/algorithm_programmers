import java.util.*;

class Solution {
    public int solution(int[] cards) {

        for (int i = 0; i < cards.length; i++) {
            cards[i]--;
        }

        Map<Integer, List<Integer>> groupToCards = new HashMap<>();
        Set<Integer> openedBoxes = new HashSet<>();

        int group = 1;

        for (int i = 0; i < cards.length; i++) {

            if (openedBoxes.contains(i)) continue;

            int currentBoxIndex = i;
            List<Integer> currentGroup = new ArrayList<>();

            while (!openedBoxes.contains(currentBoxIndex)) {
                currentGroup.add(currentBoxIndex);
                openedBoxes.add(currentBoxIndex);
                currentBoxIndex = cards[currentBoxIndex];
            }

            groupToCards.put(group, currentGroup);
            group++;
        }

        if (groupToCards.size() < 2) return 0;

        List<Integer> sizes = new ArrayList<>();
        for (List<Integer> list : groupToCards.values()) {
            sizes.add(list.size());
        }

        sizes.sort(Collections.reverseOrder());

        return sizes.get(0) * sizes.get(1);
    }
}
