class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<Math.min(k, n);i++)
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});

        while(k-- > 0 && !pq.isEmpty()) {
            int[] node = pq.poll();

            int i = node[1];
            int j = node[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if(j + 1 < m) {
                pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
        }

        return ans;
    }
}