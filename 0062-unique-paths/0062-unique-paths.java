class Solution {

    int[] dp;

    // public int solve(int i, int j, int n, int m) {
    //     if(i >= n || j >= m)
    //         return 0;

    //     if(i == n-1 && j == m-1)
    //         return 1;
        
    //     if(dp[i][j] != -1)
    //         return dp[i][j];


    //     int right = solve(i, j + 1, n, m);
    //     int down = solve(i + 1, j, n, m);

    //     return dp[i][j] = right + down;
    // }

    public int uniquePaths(int n, int m) {
        dp = new int[m];
        Arrays.fill(dp, 1);

        for(int i=1;i<n;i++) {
            
            int[] temp = dp.clone();

            for(int j=1;j<m;j++) {
                dp[j] = temp[j] + dp[j-1];
            }
        }

        // for(int i=1;i<=n;i++) {
        //     for(int j=i;j<=m;j++) {
                
        //         if(i == i && j == 1)
        //             continue;

        //         dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //     }
        // }

        return dp[m-1];
    }
}