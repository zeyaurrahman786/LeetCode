class Solution {
    // Method to check if the Sudoku board is valid
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] subGridCheck = new boolean[9];

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rowCheck[num])
                        return false;
                    rowCheck[num] = true;
                }

                // Check column
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (colCheck[num])
                        return false;
                    colCheck[num] = true;
                }

                // Check 3x3 sub-grid
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.') {
                    int num = board[rowIndex][colIndex] - '1';
                    if (subGridCheck[num])
                        return false;
                    subGridCheck[num] = true;
                }
            }
        }
        return true;
    }

    // Rest of your code (e.g., isSafe, helper, solveSudoku methods) remains the
    // same
}
