class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int pick = dp[i - 2] + nums[i];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }
}


// Bottom Up DP