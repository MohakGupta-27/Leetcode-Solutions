class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+ 1][2][k+1];
        for(int index = n-1;index >=0;index--){
            for(int cap = 1;cap <=k;cap++){
                int take = -prices[index] + dp[index + 1][0][cap];
                int skip = dp[index + 1][1][cap];
                dp[index][1][cap] = Math.max(take,skip);
                int sell = prices[index] + dp[index + 1][1][cap-1];
                int hold =  dp[index + 1][0][cap];
                dp[index][0][cap] = Math.max(sell,hold);
            }
        }
        return dp[0][1][k];
    }
}