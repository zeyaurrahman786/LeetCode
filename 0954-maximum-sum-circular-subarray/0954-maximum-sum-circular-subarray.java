class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer
        int currentMax = 0; // Variable to keep track of the current maximum subarray sum
        int minSum = Integer.MAX_VALUE; // Initialize minSum to the largest possible integer
        int currentMin = 0; // Variable to keep track of the current minimum subarray sum
        int totalSum = 0; // Variable to keep track of the total sum of the array

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}