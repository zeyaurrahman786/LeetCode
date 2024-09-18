class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0;
        int effectiveBuyPrice = prices[0];

        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - effectiveBuyPrice - fee);
            effectiveBuyPrice = Math.min(effectiveBuyPrice, prices[i] - profit);
        }

        return profit;
    }
}