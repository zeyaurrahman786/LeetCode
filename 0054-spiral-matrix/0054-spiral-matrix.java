class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int top = startCol; top <= endCol; top++) {
                res.add(matrix[startRow][top]);
            }
            // right
            for (int right = startRow + 1; right <= endRow; right++) {
                res.add(matrix[right][endCol]);
            }
            // bottom
            for (int bottom = endCol - 1; bottom >= startCol; bottom--) {
                if (startRow == endRow) {
                    break;
                }
                res.add(matrix[endRow][bottom]);
            }
            // left
            for (int left = endRow - 1; left >= startRow + 1; left--) {
                if (startCol == endCol) {
                    break;
                }
                res.add(matrix[left][startRow]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return res;
    }
}