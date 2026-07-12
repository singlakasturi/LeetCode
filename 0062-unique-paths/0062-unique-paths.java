class Solution {

    int[][] dp;

    public int solve(int i, int j, int n, int m) {
        if(i >= n || j >= m)
            return 0;

        if(i == n-1 && j == m-1)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];


        int right = solve(i, j + 1, n, m);
        int down = solve(i + 1, j, n, m);

        return dp[i][j] = right + down;
    }

    public int uniquePaths(int n, int m) {
        dp = new int[n][m];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(0, 0, n, m);
    }
}