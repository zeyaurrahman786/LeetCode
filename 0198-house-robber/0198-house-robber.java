class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int pick = a + nums[i];
            int notPick = b;
            int c = Math.max(pick, notPick);
            a = b;
            b = c;
        }
        return b;
    }
}

// Space Optimization Code