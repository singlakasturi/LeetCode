class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[] { r[1], r[2] });
            adj.get(r[1]).add(new int[] { r[0], r[2] });
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); //node, time
        pq.offer(new long[] { 0, 0 });

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;
        int mod = 1000000007;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node])
                continue;

            for (int[] nei : adj.get(node)) {

                long newDist = d + nei[1];

                if (dist[nei[0]] > newDist) {
                    pq.offer(new long[] { nei[0], newDist });
                    dist[nei[0]] = newDist;
                    ways[nei[0]] = ways[node];
                } else if (dist[nei[0]] == newDist) {
                    ways[nei[0]] = (ways[nei[0]] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}