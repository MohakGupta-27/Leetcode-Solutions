class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Check BEFORE calculating required
        if(Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int required = (sum + target) / 2;

        int[][] dp = new int[n + 1][required + 1];

        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {

            for(int j = 0; j <= required; j++) {

                // Don't take nums[i-1]
                dp[i][j] = dp[i - 1][j];

                // Take nums[i-1]
                if(nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][required];
    }
}