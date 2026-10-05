class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum= 0;
        for(int i = 0;i < n;i++){
            sum += stones[i];
        }
        int m = sum/2;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                dp[i][j] = dp[i - 1][j];

                if(stones[i - 1] <= j) {
                   dp[i][j] = Math.max(dp[i - 1][j],stones[i - 1] + dp[i - 1][j - stones[i - 1]]);
                }
            }
        }
        return sum - 2*dp[n][m];
    }
}