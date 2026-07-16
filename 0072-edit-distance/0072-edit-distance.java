class Solution {

    Integer[][] dp;

    public int solve(int i, int j, String a, String b, int n, int m) {
        if(j == m)
            return n - i;
        if(i == n)
            return m - j;

        if(dp[i][j] != null)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        if(a.charAt(i) == b.charAt(j))
            ans = Math.min(ans, solve(i+1, j+1, a, b, n, m));
        else {
            ans = Math.min(
                ans, 
                1 + Math.min(
                    Math.min(
                        solve(i, j+1, a, b, n, m), 
                        solve(i+1, j, a, b, n, m))
                , solve(i+1, j+1, a, b, n, m))
            );
        }

        return dp[i][j] = ans;
    }

    public int minDistance(String a, String b) {
        int n = a.length();
        int m = b.length();

        dp = new Integer[n][m];

        return solve(0, 0, a, b, n, m);
    }
}