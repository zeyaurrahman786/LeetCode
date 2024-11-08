class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Using Shift Operator for Optimization

        int shift = 0;
        // Find the common MSB (Most Significant Bit) of left and right
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Shift left by the common MSB to get the result
        int optimizedResult = left << shift;
        return optimizedResult;
    }
}