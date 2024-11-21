class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        // mark guard coordinates as blockers
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 1;
        }
        // mark wall coordinates as blockers
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 1;
        }
        // simulate guard's vision in all four directions
        for (int[] guard : guards) {
            int i = guard[0], j = guard[1];
            dirDfs(i - 1, j, matrix, 'L');
            dirDfs(i + 1, j, matrix, 'R');
            dirDfs(i, j - 1, matrix, 'U');
            dirDfs(i, j + 1, matrix, 'D');
        }
        int count = 0;
        // count the number of unguarded cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    count += 1;
            }
        }
        return count;
    }

    // perform dfs in only one direction given in dir variable
    private void dirDfs(int i, int j, int[][] matrix, char dir) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 1)
            return;

        matrix[i][j] = 2;
        if (dir == 'L')
            dirDfs(i - 1, j, matrix, dir);
        if (dir == 'R')
            dirDfs(i + 1, j, matrix, dir);
        if (dir == 'U')
            dirDfs(i, j - 1, matrix, dir);
        if (dir == 'D')
            dirDfs(i, j + 1, matrix, dir);
    }
}