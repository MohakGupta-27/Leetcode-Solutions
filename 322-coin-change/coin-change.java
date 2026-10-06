import java.util.Arrays;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] = amount + 1;
            }
        }
        

        // Build the table
        for(int i = 1; i <= n; i++) {

            for(int sum = 1; sum <= amount; sum++) {
                dp[i][sum] = dp[i - 1][sum];
                if(coins[i - 1] <= sum) {
                    dp[i][sum] = Math.min(1 + dp[i][sum - coins[i-1]],dp[i][sum]);
                }
            }
        }
        if(dp[n][amount] == amount + 1) {
            return -1;
        }

        return dp[n][amount];
    }
}
