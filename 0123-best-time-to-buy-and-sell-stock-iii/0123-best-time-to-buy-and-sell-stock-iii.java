// Buy and Sell Stock Pattern
// Approach - 1 Memorization

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return solve(0, n, 0, 2, prices, dp);
    }

    int solve(int index, int n, int buy, int transaction, int[] prices, int[][][] dp) {

        if (index == n || transaction == 0)
            return 0;

        if (dp[index][buy][transaction] != -1)
            return dp[index][buy][transaction];

        int profit = 0;
        if (buy == 0) {
            profit = Math.max(0 + solve(index + 1, n, 0, transaction, prices, dp),
                    -prices[index] + solve(index + 1, n, 1, transaction, prices, dp));
        }
        if (buy == 1) {
            profit = Math.max(0 + solve(index + 1, n, 1, transaction, prices, dp),
                    prices[index] + solve(index + 1, n, 0, transaction - 1, prices, dp));
        }
        return dp[index][buy][transaction] = profit;
    }
}