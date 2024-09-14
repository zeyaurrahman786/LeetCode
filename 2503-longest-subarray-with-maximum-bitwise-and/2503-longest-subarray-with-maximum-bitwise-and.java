class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, count = 0, ans = 0;
        for (int i : nums) {
            if (i == max)
                count += 1;
            else if (i > max) {
                count = ans = 1;
                max = i;
            } else {
                count = 0;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}