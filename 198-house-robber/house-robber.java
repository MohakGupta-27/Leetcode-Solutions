class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n-1,nums,dp);
    }
    public int solve(int index,int[] nums,int dp[]){
        if (index == 0)return nums[index];
        if(index < 0)return 0;
        if(dp[index] != -1)return dp[index];
        int take = nums[index] + solve(index -2,nums,dp) ;
        int notake = solve(index -1,nums,dp);
        dp[index] = Math.max(take,notake);
        return dp[index];
    }
}