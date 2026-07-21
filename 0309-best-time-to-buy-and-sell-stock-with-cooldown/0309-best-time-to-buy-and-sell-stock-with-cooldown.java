class Solution {

    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 2][2];

        dp[0][1] = 0;
        dp[1][1] = -prices[0];

        for(int i=2;i<=n+1;i++) {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i-2]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-2]);
        }

        return dp[n+1][0];
    }
}