class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    matrix = setValue(matrix, i, j);
            }
        }
        matrix = turnZero(matrix);
    }

    int[][] setValue(int matrix[][], int m, int n) {
        for (int j = 0; j < matrix[m].length; j++) {
            if (matrix[m][j] != 0)
                matrix[m][j] = -111;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][n] != 0)
                matrix[i][n] = -111;
        }
        return matrix;
    }

    int[][] turnZero(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -111)
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}