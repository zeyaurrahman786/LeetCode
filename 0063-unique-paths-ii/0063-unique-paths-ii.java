//Basic DFS : TLE as time complexity goes O(2^(M*N))

// class Solution {
//     int paths=0;
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         dfs(obstacleGrid,0,0);
//         return paths;
//     }
//     void dfs(int[][] obstacleGrid,int row,int col){
//         if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1 && obstacleGrid[row][col]==0){
//             paths++;
//             return;
//         }
//         if(row<0 || col<0 || row==obstacleGrid.length || col==obstacleGrid[0].length || obstacleGrid[row][col]==1){
//             return;
//         }
        
//         dfs(obstacleGrid,row,col+1);
//         dfs(obstacleGrid,row+1,col);
//     }
// }








//Adding Memoization for above code 
// class Solution {
//     int[][] dp;
//     public int uniquePathsWithObstacles(int[][] grid) {
//         dp = new int[grid.length][grid[0].length];
//         for(int[] d : dp) {
//             Arrays.fill(d, -1);
//         }
//         return dfs(grid, 0, 0);
//     }
    
//     int dfs(int[][] grid, int row, int col) {
//         //Exit condition
//         if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 1)
//             return 0; 
//         if(row == grid.length-1 && col == grid[0].length-1){
//             return 1;
//         }
//         if(dp[row][col] > -1) return dp[row][col];
//         dp[row][col] = dfs(grid, row, col+1) +dfs(grid, row+1, col);
//         return dp[row][col];
//     }
// }







//Top Down Approach
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1) return 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //First row && first column
                if(i == 0 || j ==0) {
                    //its prev cell was obstacle or if current cell is obstacle
                    if(grid[i][j] == 1 || (i!=0 && grid[i-1][0] == 0) || (j!=0 && grid[i][j-1] == 0)) {
                        grid[i][j] = 0;
                    }
                    else {
                        grid[i][j] = 1;
                    }
                }
                //All the other cells
                else {
                    if(grid[i][j] == 1) {
                        grid[i][j] = 0;
                    }
                    else {
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }
                }
            }
        }
        return grid[m-1][n-1];
    }
}