class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutiveAssending = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] != nums[j] + 1) {
                    isConsecutiveAssending = false;
                    break;
                }
            }

            if (isConsecutiveAssending) {
                res[i] = nums[i + k - 1];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}