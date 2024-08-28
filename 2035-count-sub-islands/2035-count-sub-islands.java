class Solution {
    private void eliminateNonSubIsland(int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;

        // Boundary check or if it's water or already visited
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return;
        }

        // Mark this cell as water in grid2
        grid2[i][j] = 0;

        // Continue DFS in 4 possible directions
        eliminateNonSubIsland(grid2, i - 1, j); // Up
        eliminateNonSubIsland(grid2, i + 1, j); // Down
        eliminateNonSubIsland(grid2, i, j - 1); // Left
        eliminateNonSubIsland(grid2, i, j + 1); // Right
    }

    private void dfs(int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;

        // Boundary check or if it's water or already visited
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return;
        }

        // Mark this cell as visited in grid2
        grid2[i][j] = 0;

        // Continue DFS in 4 possible directions
        dfs(grid2, i - 1, j); // Up
        dfs(grid2, i + 1, j); // Down
        dfs(grid2, i, j - 1); // Left
        dfs(grid2, i, j + 1); // Right
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // Count the continuous 1's in the block as 1 island.
        // If that is one island in the grid1,there may be a chance that can be separate
        // islands
        // But the inverse is not possible
        int m = grid1.length;
        int n = grid1[0].length;

        // Step 1: Eliminate non-sub-islands in grid2 by marking them
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    // This is part of an island in grid2 that cannot be a sub-island
                    eliminateNonSubIsland(grid2, i, j);
                }
            }
        }

        // Step 2: Count the remaining islands in grid2
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // This is a valid sub-island
                    count++;
                    dfs(grid2, i, j); // Mark the entire sub-island as visited
                }
            }
        }

        return count;
    }
}