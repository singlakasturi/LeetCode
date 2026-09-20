class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mappy = new HashMap<>();

        for(int i=0;i<n;i++) {
            if(mappy.containsKey(target - nums[i])) {
                return new int[]{i, mappy.get(target - nums[i])};
            }

            mappy.put(nums[i], i);
        }

        return new int[]{};
    }
}