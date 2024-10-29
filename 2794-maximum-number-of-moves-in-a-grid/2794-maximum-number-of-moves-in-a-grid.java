class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int col = n - 2; col >= 0; col--) {
            for (int row = 0; row < m; row++) {

                int maxMoves = 0;

                if (row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, dp[row - 1][col + 1] + 1);
                }

                if (grid[row][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, dp[row][col + 1] + 1);
                }

                if (row < m - 1 && grid[row + 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, dp[row + 1][col + 1] + 1);
                }

                dp[row][col] = maxMoves;
            }
        }

        int result = 0;
        for (int row = 0; row < m; row++) {
            result = Math.max(result, dp[row][0]);
        }

        return result;
    }
}