class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int case1 = solve(nums,0,n-2);
        int case2 = solve(nums,1,n-1);
        return Math.max(case1,case2);
    }
    public int solve(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        if (start == end) {
            return nums[start];
        }
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start+1]);
        for(int i = start + 2; i <= end ; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[end];
    }
}
