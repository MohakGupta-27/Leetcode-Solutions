class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];
        for(int i = 0;i < m;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1;i< m;i++){
            for(int j = 0;j<m;j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }else if( j == m-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j+1],dp[i-1][j-1])) + matrix[i][j];
                }
            }
        }
        int lastrowmin = dp[m-1][0];
        for(int i = 1 ; i < m ;i++){
            if(dp[m-1][i] < lastrowmin){
                lastrowmin = dp[m-1][i];
            }
        }
        return lastrowmin;
    }
}