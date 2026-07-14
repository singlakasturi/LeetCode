class Solution {

    int[][] dp;

    // public int solve(int i, int j, String s, int n) {
    //     if(i > j)
    //         return 0;

    //     if(i == j)
    //         return 1;

    //     if(dp[i][j] != -1)
    //         return dp[i][j];

    //     if(s.charAt(i) == s.charAt(j))
    //         dp[i][j] = 2 + solve(i+1, j-1, s, n);
    //     else    
    //         dp[i][j] = Math.max(solve(i+1, j, s, n), solve(i, j-1, s, n));
        
    //     return dp[i][j];
    // }

    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++)
            dp[i][i] = 1;

        for(int len = 2; len <= n; len++) {
            for(int i=0; i <= n - len; i++) {
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2 + dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return n - dp[0][n-1];
    }
}