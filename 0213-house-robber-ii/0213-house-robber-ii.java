class Solution {

    int solve(int i, int n, int[] nums, int[] dp ) {
        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int take = nums[i] + solve(i+2, n, nums, dp);
        int notTake = solve(i+1, n, nums, dp);

        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int ans = solve(0, n-1, nums, dp1);
        ans = Math.max(ans, solve(1, n, nums, dp2));

        return ans;

    }
}