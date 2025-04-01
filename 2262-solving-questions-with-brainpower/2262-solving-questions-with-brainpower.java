class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[i] stores the maximum points that can be earned from index i to the end
        
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            
            // Option 1: Solve the question
            int nextQuestion = i + brainpower + 1;
            long solve = points + (nextQuestion < n ? dp[nextQuestion] : 0);
            
            // Option 2: Skip the question
            long skip = dp[i + 1];
            
            // Take the maximum of both choices
            dp[i] = Math.max(solve, skip);
        }
        
        return dp[0];
    }
}
