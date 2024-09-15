// Recursive Code

// class Solution {
//     public int longestCommonSubsequence(String a, String b) {
//         return Solve(a, b, 0, 0);
//     } 

//     public int Solve(String a, String b, int i, int j) {
//         if (i == a.length() || j == b.length())
//             return 0;
//         int ans = 0;
//         if (a.charAt(i) == b.charAt(j)) {
//             ans = Solve(a, b, i + 1, j + 1) + 1;
//         } else {
//             ans = Math.max(Solve(a, b, i + 1, j), Solve(a, b, i, j + 1));
//         }
//         return ans;
//     }
// }

// Time Limited Exceeded





// Top Down DP    -> 2D DP

// class Solution {
//     public int longestCommonSubsequence(String a, String b) {
//         int[][] dp = new int[a.length()][b.length()];
//         for (int i = 0; i < a.length(); i++) {
//             for (int j = 0; j < b.length(); j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return Solve(a, b, 0, 0, dp);
//     }

//     public int Solve(String a, String b, int i, int j, int[][] dp) {
//         if (i == a.length() || j == b.length())
//             return 0;
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         int ans = 0;
//         if (a.charAt(i) == b.charAt(j)) {
//             ans = Solve(a, b, i + 1, j + 1, dp) + 1;
//         } else {
//             ans = Math.max(Solve(a, b, i + 1, j, dp), Solve(a, b, i, j + 1, dp));
//         }
//         dp[i][j] = ans;
//         return dp[i][j];
//     }
// }





// Bottom Up DP

// class Solution {
//     public int longestCommonSubsequence(String a, String b) {
//         int[][] dp = new int[a.length() + 1][b.length() + 1];
//         for (int i = a.length() - 1; i >= 0; i--) {
//             for (int j = b.length() - 1; j >= 0; j--) {
//                 int ans = 0;
//                 if (a.charAt(i) == b.charAt(j)) {
//                     ans = dp[i + 1][j + 1] + 1;
//                 } else {
//                     ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
//                 }
//                 dp[i][j] = ans;
//             }
//         }
//         return dp[0][0];
//     }
// }






// Space Optimization

class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int[] curr = new int[b.length() + 1];
        int[] next = new int[b.length() + 1];

        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (a.charAt(i) == b.charAt(j)) {
                    ans = next[j + 1] + 1;
                } else {
                    ans = Math.max(next[j], curr[j + 1]);
                }
                curr[j] = ans;
            }
            for (int k = 0; k < b.length(); k++) {
                next[k] = curr[k];
            }
        }
        return curr[0];
    }
}