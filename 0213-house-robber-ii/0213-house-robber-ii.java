class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            int pick = a + nums[i];
            int notPick = b;
            int c = Math.max(pick, notPick);
            a = b;
            b = c;
        }
        int a1 = nums[1];
        int b1 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int pick = a1 + nums[i];
            int notPick = b1;
            int c1 = Math.max(pick, notPick);
            a1 = b1;
            b1 = c1;
        }
        return Math.max(b, b1);
    }
}