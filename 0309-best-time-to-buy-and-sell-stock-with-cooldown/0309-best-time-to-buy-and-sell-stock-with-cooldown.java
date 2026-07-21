class Solution {

    int[][] dp;

    public int solve(int i, int[] prices, int canBuy, int n) {
        if(i >= n)
            return 0;

        if(dp[i][canBuy] != -1)
            return dp[i][canBuy];

        if(canBuy == 1)
            dp[i][canBuy] = Math.max(solve(i+1, prices, canBuy, n), solve(i+1, prices, 0, n) - prices[i]);
        else
            dp[i][canBuy] = Math.max(solve(i+1, prices, canBuy, n), solve(i+2, prices, 1, n) + prices[i]);

        return dp[i][canBuy]; 
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(0, prices, 1, n);
    }
}