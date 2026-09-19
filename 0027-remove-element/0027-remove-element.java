class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;

        for(int i : nums) {
            if(i != val) {
                nums[k++] = i;
            }
        }

        return k;
    }
}