class Solution {

    boolean[][] dp;

    // public boolean solve(int i, int target, int[] nums, int n) {
    //     if(target == 0)
    //         return true;

    //     if(i >= n)
    //         return false;

    //     if(dp[i][target] != null)
    //         return dp[i][target];

    //     boolean take = nums[i] <= target ? solve(i+1, target - nums[i], nums, n) : false;
    //     boolean notTake = solve(i+1, target, nums, n);

    //     return dp[i][target] = notTake || take;
    // }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;

        if(sum%2 == 1)
            return false;

        int target = sum/2;

        dp = new boolean[n][target + 1];

        for(int i=0;i<n;i++)
            dp[i][0] = true;

        if(nums[0] <= target)
            dp[0][nums[0]] = true;

        for(int i=1;i<n;i++) {
            for(int j=1;j<=target;j++) {
                boolean notTake = dp[i-1][j];
                boolean take = nums[i] <= j ? dp[i-1][j - nums[i]] : false;

                dp[i][j] = take || notTake;
            }
        }

        return dp[n-1][target];
    }
}