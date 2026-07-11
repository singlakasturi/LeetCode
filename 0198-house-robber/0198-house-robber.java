class Solution {

    int[] dp;

    public int solve(int i, int n, int[] nums) {
        if(i >= n)
            return 0;


        if(dp[i] != -1)
            return dp[i];

        
        int take = nums[i] + solve(i+2, n, nums);
        int notTake = solve(i+1, n, nums);

        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n, nums);
    }
}