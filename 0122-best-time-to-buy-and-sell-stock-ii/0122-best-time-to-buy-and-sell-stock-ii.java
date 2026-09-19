class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int ans = 0;
        int price = prices[0];

        for(int i=1;i<n;i++) {
            if(prices[i] > price) {
                ans += prices[i] - price;
                price = prices[i];
            }

            price = Math.min(price, prices[i]);
        }

        return ans;


    }
}