class Solution {

    int[][] dp;

    public int solve(int i, int j, String s, int n) {
        if(i > j)
            return 0;

        if(i == j)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == s.charAt(j))
            dp[i][j] = 2 + solve(i+1, j-1, s, n);
        else    
            dp[i][j] = Math.max(solve(i+1, j, s, n), solve(i, j-1, s, n));
        
        return dp[i][j];
    }

    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int[] i : dp)
            Arrays.fill(i, -1);

        return n - solve(0, n-1, s, n);
    }
}