class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        Solve(ans, board, n, 0);
        return ans;
    }


    public void Solve(List<List<String>> ans, char[][] board, int n, int col) {
        if (col == n) {
            ans.add(Convert(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(col, row, board, n)) {
                board[row][col] = 'Q';
                Solve(ans, board, n, col + 1);
                board[row][col] = '.';
            }
        }
    }


    public List<String> Convert(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }


    public boolean isSafe(int col, int row, char[][] board, int n) {
        int x = row, y = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = x;
        col = y;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = x;
        col = y;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
}