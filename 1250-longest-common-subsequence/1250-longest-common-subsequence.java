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








// 2D Dp

class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++){
            for (int j = 0; j < b.length(); j++){
                dp[i][j] = -1;
            }
        }
        return Solve(a, b, 0, 0, dp);
    } 

    public int Solve(String a, String b, int i, int j, int[][] dp) {
        if (i == a.length() || j == b.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];    
        int ans = 0;
        if (a.charAt(i) == b.charAt(j)) {
            ans = Solve(a, b, i + 1, j + 1, dp) + 1;
        } else {
            ans = Math.max(Solve(a, b, i + 1, j, dp), Solve(a, b, i, j + 1, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}