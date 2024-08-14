class Solution {
    public int time(int[] piles, int mid) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double) piles[i] / (double) mid);
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int i : piles) {
            high = Math.max(high, i);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = time(piles, mid);
            if (cnt > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}