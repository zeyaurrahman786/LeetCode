class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        arr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0)
                    arr[i][j] += arr[i - 1][j];
                if (j - 1 >= 0)
                    arr[i][j] += arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }
}