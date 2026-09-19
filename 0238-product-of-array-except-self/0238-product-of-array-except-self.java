class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pro = 1;
        int zeros = 0;

        for(int i : nums) {
            if(i == 0) {
                zeros++;
                continue;
            }

            pro *= i;
        }

        int[] ans = new int[n];

            if(zeros > 1)
                Arrays.fill(ans, 0);

            else if(zeros == 1) {
                for(int i=0;i<n;i++) {
                    if(nums[i] != 0)
                        ans[i] = 0;
                    else
                        ans[i] = pro;
                }
            }

            else {
                for(int i=0;i<n;i++) {
                    ans[i] = pro/nums[i];
                }
            }

        return ans;
    }
}