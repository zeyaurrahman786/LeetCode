class Solution {
    public int fun(int[] arr, int i, int take, int count, int[][][] dp) {
        if (i >= arr.length || count == 0) {
            return 0;
        }
        if (dp[i][take][count] != -1) {
            return dp[i][take][count];
        }
        int taken = 0;
        int notTaken = 0;
        if (take == 1) {
            taken = -arr[i] + fun(arr, i + 1, 0, count, dp);
            notTaken = fun(arr, i + 1, 1, count, dp);
        } else {
            taken = arr[i] + fun(arr, i + 1, 1, count - 1, dp);
            notTaken = fun(arr, i + 1, 0, count, dp);
        }
        return dp[i][take][count] = Math.max(taken, notTaken);
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 2][2][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int t = 0; t < dp[i][j].length; t++) {
                    dp[i][j][t] = -1;
                }
            }
        }
        return fun(prices, 0, 1, k, dp);
    }
}