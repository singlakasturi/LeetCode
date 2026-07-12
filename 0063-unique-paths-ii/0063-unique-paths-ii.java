class Solution {

    int[] dp;

    // public int solve(int i, int j, int[][] o, int n, int  m) {
    //     if(i >= n || j >= m || o[i][j] == 1)
    //         return 0;

    //     if(i == n-1 && j == m-1)
    //         return 1;

    //     if(dp[i][j] != -1)
    //         return dp[i][j];

    //     int right = solve(i+1, j, o, n, m);
    //     int down = solve(i, j+1, o, n, m);

    //     return dp[i][j] = right + down;
    // }

    public int uniquePathsWithObstacles(int[][] o) {
        int n = o.length;
        int m = o[0].length;

        if(o[0][0] == 1 || o[n-1][m-1] == 1)
            return 0;

        dp = new int[m];
        
        dp[0] = 1;

        for(int i=0;i<n;i++) {
            if(o[i][0] == 1)
                dp[0] = 0;
            for(int j=1;j<m;j++) {
                if(o[i][j] == 1)
                    dp[j] = 0;
                else
                    dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[m-1];

    }
}