class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return solve(0, 0, s1, s2, s3, dp) == 1;
    }

    private int solve(int i, int j, String s1, String s2, String s3, int[][] dp) {
        if (i == s1.length() && j == s2.length())
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i < s1.length() && i + j < s3.length() && s1.charAt(i) == s3.charAt(i + j)
                && solve(i + 1, j, s1, s2, s3, dp) == 1)
            return dp[i][j] = 1;

        if (j < s2.length() && i + j < s3.length() && s2.charAt(j) == s3.charAt(i + j)
                && solve(i, j + 1, s1, s2, s3, dp) == 1)
            return dp[i][j] = 1;

        return dp[i][j] = 0;
    }
}