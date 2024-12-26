class Solution {
    private int recursion(int index, int ts, int[] arr) {
        if (ts == 0) return 1;
        if (index == 0) return arr[index] == ts ? 1 : 0;

        int notInclude = recursion(index - 1, ts, arr);
        int include = 0;
        if (arr[index] <= ts) {
            include = recursion(index - 1, ts - arr[index], arr);
        }
        return notInclude + include;
    }

    private int memoization(int index, int ts, int[] arr, int[][] dp) {
        if (index == 0) {
            if (ts == 0 && arr[0] == 0) return 2;
            if (ts == 0 || ts == arr[0]) return 1;
            return 0;
        }
        if (dp[index][ts] != -1) return dp[index][ts];

        int notInclude = memoization(index - 1, ts, arr, dp);
        int include = 0;
        if (arr[index] <= ts) {
            include = memoization(index - 1, ts - arr[index], arr, dp);
        }
        return dp[index][ts] = notInclude + include;
    }

    private int tabulation(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int T = 0; T <= target; T++) {
                int notInclude = dp[index - 1][T];
                int include = 0;
                if (nums[index] <= T) {
                    include = dp[index - 1][T - nums[index]];
                }
                dp[index][T] = notInclude + include;
            }
        }
        return dp[n - 1][target];
    }

    private int spaceOptimization(int[] nums, int target) {
        int sm = 0;
        for (int num : nums) sm += num;

        if (sm < Math.abs(target) || (sm + target) % 2 != 0) return 0;
        int totalsum = (sm + target) / 2;

        int[] dp = new int[totalsum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int T = totalsum; T >= num; T--) {
                dp[T] += dp[T - num];
            }
        }
        return dp[totalsum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        return spaceOptimization(nums, target);
    }
}