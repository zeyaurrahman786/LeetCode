class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        if (arraySum % 2 != 0) {
            return false;
        }
        int subsetSum = arraySum / 2;
        boolean[][] dp = new boolean[subsetSum + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= subsetSum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                }
            }
        }
        return dp[subsetSum][nums.length];
    }
}