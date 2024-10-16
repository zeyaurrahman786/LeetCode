class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns

        // Modify the grid in-place to store the minimum path sum at each cell

        // Fill the first row by accumulating the values
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // Fill the first column by accumulating the values
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Take the minimum value from the top or left, and add the current cell value
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // The bottom-right corner will contain the minimum path sum
        return grid[m - 1][n - 1];
    }
}
