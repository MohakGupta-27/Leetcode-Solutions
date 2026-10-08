class Solution {
    public int longestPalindromeSubseq(String s) {
        int a = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        if(a == 0)return 0;
        int[][] dp = new int[a+1][a+1];
        for(int i = 1;i <= a;i++){
            for(int j = 1;j <= a;j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[a][a];
    }
}