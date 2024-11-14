class Solution {

    public boolean isSafe(char board[][], int row, int col) {
        int n = board.length;
        // chack row contain any other Queen
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q')
                return false;
        }
        // chack col contain any other Queen
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // north east:
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        // south east:
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }

        // south west:
        i = row;
        j = col;
        while (j >= 0 && i < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }

        // north west::
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        return true;
    }

    public void setQueen(char board[][], int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += board[i][j];
                }
                list.add(s);
            }
            ans.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                setQueen(board, row + 1, ans);
                board[row][i] = '.';
            }
        }

    }

    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
            System.out.println();
        }
        setQueen(board, 0, ans);
        return ans.size();
    }
}