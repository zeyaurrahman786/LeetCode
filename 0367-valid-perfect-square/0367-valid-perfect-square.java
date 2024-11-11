class Solution {
    boolean isPerfectSquare(int num) {

        int high = 100000;
        int low = 1;
        long mid; // Change mid to long to avoid overflow
        long sq; // Change sq to long to avoid overflow

        while (low <= high) {
            mid = low + (high - low) / 2;
            sq = mid * mid;
            if (sq == num)
                return true;
            else if (sq > num)
                high = (int) mid - 1;
            else
                low = (int) mid + 1;
        }
        return false;
    }
}
