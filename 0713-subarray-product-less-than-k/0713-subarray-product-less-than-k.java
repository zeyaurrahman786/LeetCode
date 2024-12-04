class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int n = nums.length;
        int start = 0;
        int end = 0;
        int prod = 1;
        int count = 0;

        while (end < n) {
            // expansion
            prod = prod * nums[end];
            // shrinking
            while (prod >= k) {
                prod = prod / nums[start];
                start++;
            }
            count = count + (end - start + 1);
            end++;
        }
        return count;
    }
}