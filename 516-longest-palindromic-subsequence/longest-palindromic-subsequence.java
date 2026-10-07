class Solution {
    public int longestPalindromeSubseq(String s) {
        int a = s.length();
        String s2 = "";
        for(int i =a-1; i >=0;i--){
            s2 += s.charAt(i);
        }
        int b = s2.length();
        if(a == 0)return 0;
        int[][] dp = new int[a+1][b+1];
        for(int i = 1;i <= a;i++){
            for(int j = 1;j <= b;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[a][b];
    }
}