class Solution {
    public int takeCharacters(String s, int k) {
        int[] totalCount = new int[3];
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k)
            return -1;

        int n = s.length();
        int minMoves = n;

        int[] wc = new int[3];
        int left = 0;

        for (int right = 0; right < n; right++) {
            wc[s.charAt(right) - 'a']++;

            while (wc[0] > totalCount[0] - k ||
                    wc[1] > totalCount[1] - k ||
                    wc[2] > totalCount[2] - k) {
                wc[s.charAt(left) - 'a']--;
                left++;
            }
            minMoves = Math.min(minMoves, n - (right - left + 1));
        }
        return minMoves;
    }
}