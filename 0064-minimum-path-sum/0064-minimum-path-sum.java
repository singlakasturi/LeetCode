class Solution {

    int[][] dp;

    // public int solve(int i, int j, int[][] grid, int n, int m) {
    //     if(i >= n || j >= m)
    //         return Integer.MAX_VALUE;

    //     if(i == n-1 && j == m-1)
    //         return grid[i][j];

    //     if(dp[i][j] != -1)
    //         return dp[i][j];

    //     int right = solve(i, j+1, grid, n, m);
    //     int down = solve(i + 1, j, grid, n, m);

    //     int ans = Math.min(right, down);
    //     if(ans == Integer.MAX_VALUE)
    //         return ans;

    //     return dp[i][j] = grid[i][j] + ans;
    // }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];
        dp[0][0] = grid[0][0];

        for(int i=1;i<n;i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j=1;j<m;j++)
            dp[0][j] = grid[0][j] + dp[0][j-1];

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                int ans = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = grid[i][j] + ans;
            }
        }

        return dp[n-1][m-1];
    }
}