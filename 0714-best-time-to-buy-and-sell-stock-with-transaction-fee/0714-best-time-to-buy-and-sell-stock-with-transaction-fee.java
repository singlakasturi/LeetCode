class Solution {


    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] behind = new int[2];
        int[] curr = new int[2];

        behind[0] = 0;
        behind[1] = -prices[0];

        for(int i=1;i<=n;i++) {
            curr[1] = Math.max(behind[1], behind[0] - prices[i-1]);
            curr[0] = Math.max(behind[0], behind[1] + prices[i - 1] - fee);

            behind = curr;
        }

        return curr[0];
    }
}