class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;

        // Search for the first occurrence
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arr[0] = i;
                break;
            }
        }

        // If the first occurrence is found, search for the last occurrence
        if (arr[0] != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    arr[1] = i;
                    break;
                }
            }
        }

        return arr;
    }
}
