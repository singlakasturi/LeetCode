class Solution {

    int[][] dp;

    public int solve(int i, int j, String a, String b, int n, int m) {
        if(i >= n || j >= m)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;

        if(a.charAt(i) == b.charAt(j)) {
            ans = 1 + solve(i+1, j+1, a, b, n, m);
        }
        else {
            ans = Math.max(ans, Math.max(solve(i+1, j, a, b, n, m), solve(i, j+1, a, b, n, m)));
        }

        return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        dp = new int[n][m];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(0, 0, a, b, n, m);
    }
}