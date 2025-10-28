class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (canMakeZero(nums.clone(), i, 1))
                    result++; // right
                if (canMakeZero(nums.clone(), i, -1))
                    result++; // left
            }
        }
        return result;
    }

    private boolean canMakeZero(int[] arr, int curr, int dir) {
        int n = arr.length;
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0)
                curr += dir;
            else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int num : arr)
            if (num != 0)
                return false;
        return true;
    }
}
