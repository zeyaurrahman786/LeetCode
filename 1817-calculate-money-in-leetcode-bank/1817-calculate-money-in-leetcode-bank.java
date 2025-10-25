class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int remainingDays = n % 7;
        int total = 0;

        // Sum for full weeks
        total += 28 * weeks + 7 * (weeks * (weeks - 1)) / 2;

        // Sum for remaining days
        for (int i = 0; i < remainingDays; i++) {
            total += (weeks + 1) + i;
        }

        return total;
    }
}
