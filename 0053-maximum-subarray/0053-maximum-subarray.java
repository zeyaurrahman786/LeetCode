class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > ans)
                ans = sum;
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }
}
