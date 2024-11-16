class Solution {
    public int countNegatives(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int row = 0, col = totalCols - 1, count = 0;
        while (row < totalRows && col >= 0) {
            if (grid[row][col] < 0) {
                col--;
                count += totalRows - row;
            } else {
                row++;
            }
        }
        return count;
    }
}

