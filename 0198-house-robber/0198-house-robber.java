class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = Solve(nums, n - 1, dp);
        return ans;
    }

    public int Solve(int[] nums, int n, int[] dp) {
        if (n < 0)
            return 0;
        if (n == 0)
            return nums[0];
        if (dp[n] != -1)
            return dp[n];
        int pick = Solve(nums, n - 2, dp) + nums[n];
        int notPick = Solve(nums, n - 1, dp);
        dp[n] = Math.max(pick, notPick);
        return dp[n];
    }
}