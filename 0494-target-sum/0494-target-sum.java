class Solution {

    int[][] dp;

    public int solve(int i, int target, int[] nums, int n) {

        if(i == n-1) {
            if(target == 0 && nums[i] == 0)
                return 2;
            if(nums[i] == target || target == 0)
                return 1;
            
            return 0;
        }

        if(target < 0 || i >= n)
            return 0;

        if(dp[i][target] != -1)
            return dp[i][target];

        int take = nums[i] <= target ? solve(i+1, target - nums[i], nums, n) : 0;
        int notTake = solve(i+1, target, nums, n);

        return dp[i][target] = notTake + take;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;

        if(target > sum || target < -sum || (target + sum) % 2 == 1)
            return 0;
        
        int tar = (sum + target)/2;

        dp = new int[n][tar + 1];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(0, tar, nums, n);
    }
}