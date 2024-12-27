class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0; // To store the maximum score
        int bestI = values[0]; // To store the best value of values[i] + i so far

        // Iterate through the array starting from index 1
        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair (bestI + values[j] - j)
            maxScore = Math.max(maxScore, bestI + values[j] - j);
            // Update bestI for future pairs
            bestI = Math.max(bestI, values[j] + j);
        }

        return maxScore;
    }
}
