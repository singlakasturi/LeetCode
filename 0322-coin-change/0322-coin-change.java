class Solution {

    int[] dp;

    // public int solve(int amount, int[] coins) {

    //     if(amount == 0)
    //         return 0;

    //     if(amount < 0)
    //         return Integer.MAX_VALUE;

    //     if(dp[amount] != -1)
    //         return dp[amount];

    //     int ans = Integer.MAX_VALUE;

    //     for(int coin : coins) {
    //         int rem = solve(amount - coin, coins);

    //         if(rem != Integer.MAX_VALUE)
    //             ans = Math.min(ans, 1 + rem);
    //     }

    //     return dp[amount] = ans;

        
    // }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int a = 1; a <= amount; a++) {
            for(int coin : coins) {
                if(coin <= a && dp[a - coin] != Integer.MAX_VALUE) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}