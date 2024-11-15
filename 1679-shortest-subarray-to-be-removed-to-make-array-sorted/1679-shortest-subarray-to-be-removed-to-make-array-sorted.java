class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find the left sorted segment
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // Already Sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the right sorted segment
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int minRemoval = Math.min(n - left - 1, right);

        // Merge left and right part
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minRemoval = Math.min(minRemoval, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return minRemoval;
    }
}

// TC -> O(N)
// SC -> O(1)