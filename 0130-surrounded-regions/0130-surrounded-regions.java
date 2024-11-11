// METHOD-1

class Solution {
    boolean seen;

    private void mark(char[][] board, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] == 'X') 
            return;

        board[i][j] = 'X';
        mark(board, i - 1, j, r, c);
        mark(board, i + 1, j, r, c);
        mark(board, i, j - 1, r, c);
        mark(board, i, j + 1, r, c);
    }

    private void dfs(char[][] board, int i, int j, int r, int c, boolean[][] visited) {
        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] == 'X' || visited[i][j])
            return;

        if (i <= 0 || i >= r - 1 || j <= 0 || j >= c - 1) 
            seen = true;

        visited[i][j] = true;
        dfs(board, i - 1, j, r, c, visited);
        dfs(board, i + 1, j, r, c, visited);
        dfs(board, i, j - 1, r, c, visited);
        dfs(board, i, j + 1, r, c, visited);
    }

    public void solve(char[][] board) {
        int r = board.length;
        if (r <= 1)
            return;
        int c = board[0].length;
        if (c <= 1)
            return;

        boolean[][] visited = new boolean[r][c];

        for (int i = 1; i < r - 1; ++i) {
            for (int j = 1; j < c - 1; ++j) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    seen = false;
                    dfs(board, i, j, r, c, visited);
                    if (!seen)
                        mark(board, i, j, r, c);
                    seen = true;
                }
            }
        }
    }
}

// METHOD-2

// class Solution {
//     private void dfs(char[][] grid, int i, int j) {
//         if (grid[i][j] == 'O') {
//             grid[i][j] = '1';

//             if (i + 1 < grid.length) dfs(grid, i + 1, j);
//             if (i > 1) dfs(grid, i - 1, j);
//             if (j + 1 < grid[i].length) dfs(grid, i, j + 1);
//             if (j > 1) dfs(grid, i, j - 1);
//         }
//     }

//     public void solve(char[][] grid) {
//         if (grid.length == 0)
//             return;
//         int row = grid.length, col = grid[0].length;

//         // First row and last row
//         for (int i = 0; i < row; i++) {
//             dfs(grid, i, 0);
//             dfs(grid, i, col - 1);
//         }

//         // First col and last col
//         for (int j = 1; j < col - 1; j++) {
//             dfs(grid, 0, j);
//             dfs(grid, row - 1, j);
//         }

//         for (int i = 0; i < row; ++i) {
//             for (int j = 0; j < col; ++j) {
//                 if (grid[i][j] == 'O') 
//                     grid[i][j] = 'X';
//                 else if (grid[i][j] == '1') 
//                     grid[i][j] = 'O';
//             }
//         }
//     }
// }
