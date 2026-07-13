class Solution {

    int[] dp;

    public int solve(int amount, int[] coins) {

        if(amount == 0)
            return 0;

        if(amount < 0)
            return Integer.MAX_VALUE;

        if(dp[amount] != -1)
            return dp[amount];

        int ans = Integer.MAX_VALUE;

        for(int coin : coins) {
            int rem = solve(amount - coin, coins);

            if(rem != Integer.MAX_VALUE)
                ans = Math.min(ans, 1 + rem);
        }

        return dp[amount] = ans;

        
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int ans = solve(amount, coins);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}