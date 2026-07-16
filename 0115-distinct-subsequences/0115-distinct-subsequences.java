class Solution {

    Integer[][] dp;

    public int solve(int i, int j, String s, String t, int n, int m){ 
        if(j == m)
            return 1;
        if(i >= n)
            return 0;

        if(dp[i][j] != null)
            return dp[i][j];

        int take = s.charAt(i) == t.charAt(j) ? solve(i+1, j+1, s, t, n, m) : 0;
        int notTake = solve(i+1, j, s, t, n, m);

        long ans = take + notTake;

        return dp[i][j] = (int) ans;
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new Integer[n][m];

        return solve(0, 0, s, t, n, m);
    }
}