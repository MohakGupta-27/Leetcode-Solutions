class Solution {
    public int minInsertions(String s) {
        int a = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        if(a == 0)return 0;
        int[] dp = new int[a + 1];

        for (int i = 1; i <= a; i++) {

            int prev = 0;

            for (int j = 1; j <= a; j++) {

                int temp = dp[j];

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }
        return a - dp[a];
    }
}