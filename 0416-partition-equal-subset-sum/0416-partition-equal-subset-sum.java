class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum = 0;

        // Calculate sum of array.
        for (int num : nums) {
            arraySum += num;
        }

        // If total sum is odd, it cannot be partitioned into equal sum subsets.
        if (arraySum % 2 != 0) {
            return false;
        }

        // Calculate the subset sum.
        int subsetSum = arraySum / 2;

        // Create a lookup table and fill all entries with FALSE.
        boolean[][] dp = new boolean[subsetSum + 1][nums.length + 1];

        // Initialize the first row as TRUE as each array has a subset whose sum is zero
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }

        // Fill the lookup table in a bottom-up manner.
        for (int i = 1; i <= subsetSum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                }
            }
        }

        // Return the last index of the matrix, which is our answer.
        return dp[subsetSum][nums.length];
    }
}