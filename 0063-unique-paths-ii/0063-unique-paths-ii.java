class Solution {

    int[][] dp;

    public int solve(int i, int j, int[][] o, int n, int  m) {
        if(i >= n || j >= m || o[i][j] == 1)
            return 0;

        if(i == n-1 && j == m-1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i+1, j, o, n, m);
        int down = solve(i, j+1, o, n, m);

        return dp[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] o) {
        int n = o.length;
        int m = o[0].length;

        dp = new int[n][m];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(0, 0, o, n, m);
    }
}