class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int price = prices[0];
        int ans = 0;

        for(int i=1;i<n;i++) {
            int profit = prices[i] - price;
            ans = Math.max(ans, profit);

            price = Math.min(price, prices[i]);
        }

        return ans;
    }
}