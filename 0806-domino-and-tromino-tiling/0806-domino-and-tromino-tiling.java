class Solution {
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = ((2 * dp[i - 1]) % 1000000007 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }
}