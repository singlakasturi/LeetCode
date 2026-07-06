class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        for(int[] t : times)
            adj.get(t[0]).add(new int[]{t[1], t[2]});

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // node, time

        pq.offer(new int[]{k, 0});

        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();

            if(node[1] > cost[node[0]])
                continue;

            for(int[] i : adj.get(node[0])) {
                if(cost[i[0]] > i[1] + node[1]) {
                    cost[i[0]] = i[1] + node[1];
                    pq.offer(new int[]{i[0], cost[i[0]]});
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++)
            if(cost[i] == Integer.MAX_VALUE)
                return -1;
            else
                ans = Math.max(ans, cost[i]);

        return ans;
    }
}