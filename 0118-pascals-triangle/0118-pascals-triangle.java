class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case: Add the first row [1]
        if (numRows == 0) {
            return triangle;
        }

        // Add the first row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Generate each row starting from the second row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            // First element of the row is always 1
            row.add(1);

            // Calculate the middle elements
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of the row is always 1
            row.add(1);

            // Add the current row to the triangle
            triangle.add(row);
        }

        return triangle;
    }
}