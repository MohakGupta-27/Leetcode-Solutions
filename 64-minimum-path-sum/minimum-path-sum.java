class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,dp,grid);
    }
    int solve(int i, int j,int[][] dp,int[][] grid) {

        if(i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(i + 1, j, dp,grid);
        int right = solve(i, j + 1,dp,grid);
        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }
}