class Solution {

    int[][][] dp;

    // public int solve(int[] prices, int i, int canBuy, int cap, int n, int k) {
    //     if(i == n || cap == k)
    //         return 0;

    //     if(dp[i][canBuy][cap] != null)
    //         return dp[i][canBuy][cap];

    //     if(canBuy == 1)
    //         dp[i][canBuy][cap] = Math.max(solve(prices, i+1, 1, cap, n, k), solve(prices, i+1, 0, cap, n, k) - prices[i]);
    //     else
    //         dp[i][canBuy][cap] = Math.max(solve(prices, i+1, 0, cap, n, k), solve(prices, i+1, 1, cap + 1, n, k) + prices[i]);

    //     return dp[i][canBuy][cap];
    // }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = k - 1; cap >= 0; cap--) {

                dp[i][1][cap] = Math.max(dp[i + 1][1][cap], dp[i + 1][0][cap] - prices[i]);

                dp[i][0][cap] = Math.max(dp[i + 1][0][cap], dp[i + 1][1][cap + 1] + prices[i]);

            }

        }

        return dp[0][1][0];

    }
}