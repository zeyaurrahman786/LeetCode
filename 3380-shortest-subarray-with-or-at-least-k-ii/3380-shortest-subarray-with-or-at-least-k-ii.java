class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, ans = n + 1, start = 0;
        // bits array to count contributions
        int bits[] = new int[32];
        for (int end = 0; end < n; end++) {
            update(bits, nums[end], 1);
            // shrink window if special subarray found
            while (start <= end && bitsToNumber(bits) >= k) {
                ans = Math.min(ans, end - start + 1);
                update(bits, nums[start++], -1);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }

    // increments or decrements number of contributions
    private void update(int bits[], int num, int val) {
        for (int i = 0; i < 32; i++) {
            if ((num >> i & 1) != 0)
                bits[i] += val;
        }
    }

    // converts bits array to a number
    private int bitsToNumber(int[] bits) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}