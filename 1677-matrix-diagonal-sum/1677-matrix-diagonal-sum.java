class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            // Primary diagonal sum
            sum += mat[i][i];
            // Secondary diagonal sum
            if (i != mat.length - 1 - i) {
                sum += mat[i][mat.length - i - 1];
            }
        }
        return sum;
    }
}