class Solution {
    public int minPatches(int[] nums, int n) {
        long minNumberPatches = 0, maxNumber = 0;
        int i = 0, len = nums.length;

        while (maxNumber < n) {
            if (i < len && maxNumber + 1 >= nums[i]) {
                maxNumber += nums[i];
                i++;
            } else {
                minNumberPatches++;
                maxNumber += (maxNumber + 1);
            }
        }
        return (int) minNumberPatches;
    }
}