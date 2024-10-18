class Solution {
    public int maxOr = 0;
    public int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        for (int num : nums)
            maxOr |= num;
        backtrack(nums, n, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int n, int index, int currOr) {
        if (index == n) {
            if (currOr == maxOr) {
                count++;
            }
            return;
        }
        backtrack(nums, n, index + 1, currOr | nums[index]);
        backtrack(nums, n, index + 1, currOr);
    }
}