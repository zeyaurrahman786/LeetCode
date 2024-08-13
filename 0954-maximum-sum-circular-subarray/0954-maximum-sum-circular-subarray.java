class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int neg = 0, max = nums[0];
        for (int i : nums) {
            if (i < 0)
                neg++;
            max = Math.max(max, i);
        }
        int n = nums.length;
        if (neg == n)
            return max;
        int ans1 = Kadane(nums);
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++)
            nums[i] = -nums[i];
        int ans2 = Kadane(nums);
        return Math.max(ans1, ans2 + sum);
    }

    // Kadane's Algorithm
    public int Kadane(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }
}