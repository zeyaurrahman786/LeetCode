class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int size = nums.length;
        int left = 0, right = nums[size - 1] - nums[0];
        int ans = -1;
        while (left <= right) {
            int propDiff = left + (right - left) / 2;
            int propDiffPairCnt = countPairs(propDiff, nums);
            if (propDiffPairCnt < k) {
                left = propDiff + 1;
            } else {
                ans = propDiff;
                right = propDiff - 1;
            }
        }
        return ans;
    }

    private int countPairs(int propDiff, int nums[]) {
        int pairCnt = 0, left = 0, right = 0, size = nums.length;
        while (right < size) {
            while (nums[right] - nums[left] > propDiff)
                left++;
            pairCnt += right - left;
            right++;
        }
        return pairCnt;
    }
}