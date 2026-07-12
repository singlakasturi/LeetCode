class Solution {

    int[] dp;

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

        dp = new int[m];
        dp[0] = grid[0][0];


        for(int j=1;j<m;j++)
            dp[j] = grid[0][j] + dp[j-1];

        for(int i=1;i<n;i++) {
            dp[0] = grid[i][0] + dp[0];
            for(int j=1;j<m;j++) {
                int ans = Math.min(dp[j], dp[j-1]);
                dp[j] = grid[i][j] + ans;
            }
        }

        return dp[m-1];
    }
}