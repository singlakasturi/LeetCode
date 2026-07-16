class Solution {

    int[] dp;

    // public int solve(int i, int j, String s, String t, int n, int m){ 
    //     if(j == m)
    //         return 1;
    //     if(i >= n)
    //         return 0;

    //     if(dp[i][j] != null)
    //         return dp[i][j];

    //     int take = s.charAt(i) == t.charAt(j) ? solve(i+1, j+1, s, t, n, m) : 0;
    //     int notTake = solve(i+1, j, s, t, n, m);

    //     long ans = take + notTake;

    //     return dp[i][j] = (int) ans;
    // }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[m+1];

        dp[0] = 1;

        for(int i=1;i<=n;i++) {
            int[] temp = dp.clone();
            for(int j=1;j<=m;j++) {
                int take = s.charAt(i-1) == t.charAt(j-1) ? temp[j-1] : 0;
                int notTake = temp[j];

                dp[j] = take + notTake;
            }
        }

        return dp[m];
    }
}