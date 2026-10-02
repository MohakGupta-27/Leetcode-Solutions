class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum= 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        int m = sum/2;
        boolean[][] dp = new boolean[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                dp[i][j] = dp[i - 1][j];

                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][m];
    }
}