class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,obstacleGrid,dp);
    }
    int solve(int i, int j,int[][] obstacleGrid ,int[][] dp) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(i >= m || j >= n) {
            return 0;
        }
        if(obstacleGrid[i][j] == 1) {
            return 0;
        }
        if(i == m - 1 && j == n - 1) {
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] =
        solve(i + 1, j,obstacleGrid, dp)
        +
        solve(i, j + 1, obstacleGrid, dp);
        return dp[i][j];
    }
}