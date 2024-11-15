/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low = 1;
        long high = n;
        long mid;
        int result = n;

        while (low <= high) {
            mid = low + (high - low) / 2; // To avoid potential overflow
            if (isBadVersion((int)mid)) {
                result = (int)mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
