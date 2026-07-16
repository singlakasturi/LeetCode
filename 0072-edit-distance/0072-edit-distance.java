class Solution {

    int[][] dp;

    // public int solve(int i, int j, String a, String b, int n, int m) {
    //     if(j == m)
    //         return n - i;
    //     if(i == n)
    //         return m - j;

    //     if(dp[i][j] != null)
    //         return dp[i][j];

    //     int ans = int.MAX_VALUE;

    //     if(a.charAt(i) == b.charAt(j))
    //         ans = Math.min(ans, solve(i+1, j+1, a, b, n, m));
    //     else {
    //         ans = Math.min(
    //             ans, 
    //             1 + Math.min(
    //                 Math.min(
    //                     solve(i, j+1, a, b, n, m), 
    //                     solve(i+1, j, a, b, n, m))
    //             , solve(i+1, j+1, a, b, n, m))
    //         );
    //     }

    //     return dp[i][j] = ans;
    // }

    public int minDistance(String a, String b) {
        int n = a.length();
        int m = b.length();

        dp = new int[n + 1][m + 1];

        for(int i=0;i<=m;i++)
            dp[0][i] = i;
        for(int i=0;i<=n;i++)
            dp[i][0] = i;

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                int ans = Integer.MAX_VALUE;
                if(a.charAt(i-1) == b.charAt(j-1))
                    ans = Math.min(ans, dp[i-1][j-1]);
                else {
                    ans = 1 + Math.min(ans, Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])));
                }

                dp[i][j] = ans;
            }
        }

        return dp[n][m];
    }
}