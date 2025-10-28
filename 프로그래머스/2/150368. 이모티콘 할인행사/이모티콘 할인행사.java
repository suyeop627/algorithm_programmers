class Solution {
    int[] discounts = {10, 20, 30, 40};
    int maxSubscriber = 0;
    int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxSubscriber, maxSales};
    }

    private void dfs(int depth, int[] appliedDiscounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            evaluate(users, emoticons, appliedDiscounts);
            return;
        }

        for (int d : discounts) {
            appliedDiscounts[depth] = d;
            dfs(depth + 1, appliedDiscounts, users, emoticons);
        }
    }

    private void evaluate(int[][] users, int[] emoticons, int[] appliedDiscounts) {
        int subscriberCount = 0;
        int totalSales = 0;

        for (int[] user : users) {
            int discountRateThreshold = user[0];
            int priceThreshold = user[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (appliedDiscounts[i] >= discountRateThreshold) {
                    sum += emoticons[i] * (100 - appliedDiscounts[i]) / 100;
                }
            }

            if (sum >= priceThreshold) {
                subscriberCount++;
            } else {
                totalSales += sum;
            }
        }

        if (subscriberCount > maxSubscriber 
            || (subscriberCount == maxSubscriber && totalSales > maxSales)) {
            maxSubscriber = subscriberCount;
            maxSales = totalSales;
        }
    }
}