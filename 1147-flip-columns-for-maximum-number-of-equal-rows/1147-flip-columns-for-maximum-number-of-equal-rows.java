class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder values = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            for (int r : row) {
                // create string representation of a row
                values.append(r);
                // create string representation of a flipped row
                flipped.append(1 - r);
            }
            String vs = values.toString();
            String fs = flipped.toString();
            // put string representation of a row with count=prev+1
            map.put(vs, map.getOrDefault(vs, 0) + 1);
            // put string representation of a flipped row with count=prev+1
            map.put(fs, map.getOrDefault(fs, 0) + 1);
        }

        int ans = 0;
        // get the max value, it represents the max number of rows which match
        // or totally different i.e. flipped version.
        for (int v : map.values())
            ans = Math.max(ans, v);
        return ans;
    }
}