class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int maxStreak = 0;

        for (int i : nums) {
            int streak = 1;
            long curr = i;

            while (set.contains((int) (curr * curr)) && curr * curr <= Integer.MAX_VALUE) {
                curr = curr * curr;
                streak++;
            }
            maxStreak = Math.max(maxStreak, streak);
        }
        return maxStreak == 1 ? -1 : maxStreak;
    }
}
