class Solution {
    public int maxProfit(int[] prices) {
        int price = prices[0];
        int ans = 0;
        int n = prices.length;

        for(int i=1;i<n;i++) {
            if(prices[i] - price > 0) {
                ans += (prices[i] - price);
                price = prices[i];
            }

            price = Math.min(price, prices[i]);

        }

        return ans;
    }
}