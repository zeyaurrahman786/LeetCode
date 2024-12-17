class Solution {

    public String subStrHash(String s, int p, int m, int k, int t) {

        long h = 0, kp = 1; // avoid overflow
        int ans = 0, n = s.length();

        for (int i = n - 1; i >= 0; i--) {

            h = (h * p + val(s.charAt(i))) % m;

            if (i + k >= n) {
                kp = kp * p % m;
            } else {
                h = (h - val(s.charAt(i + k)) * kp % m + m) % m;
            }

            if (h == t) {
                ans = i;
            }
        }
        return s.substring(ans, ans + k);

    }

    private int val(char c) { // find index
        return c - 'a' + 1;
    }
};