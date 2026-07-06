class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] e : flights)
            adj.get(e[0]).add(new int[]{e[1], e[2]});

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));    // node, cost, k

        // pq.offer(new int[]{src, 0, 0});


        // while(!pq.isEmpty()) {
        //     int[] node = pq.poll();

        //     if(node[0] == dst)
        //         return node[1];

        //     for(int[] nei : adj.get(node[0])) {
        //         if(node[2] + 1 <= k + 1) {
        //             pq.offer(new int[]{nei[0], node[1] + nei[1], node[2] + 1});
        //         }
        //     }
        // }

        // return -1;



        Queue<int[]> q = new LinkedList<>(); // node, cost;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(new int[]{src, 0});
        dist[src] = 0;

        // while(!q.isEmpty()) {
        //     int[] node = q.poll();

        //     // if(node[0] == dst)
        //     //     return dist[dst];

        //     for(int[] nei : adj.get(node[0])) {
        //         if(dist[nei[0]] > dist[node[0]] + nei[1] && node[1] + 1 <= k + 1) {
        //             dist[nei[0]] = dist[node[0]] + nei[1];
        //             q.offer(new int[]{nei[0], node[1] + 1});
        //         }
        //     }
        // }

        int level = 0;

        while(!q.isEmpty() && level <= k) {
            int size = q.size();
            int[] temp = dist.clone();

            while(size-- > 0) {
                int[] curr = q.poll();

                for(int[] nei : adj.get(curr[0])) {
                    if(temp[nei[0]] > curr[1] + nei[1]) {
                        temp[nei[0]] = curr[1] + nei[1];
                        q.offer(new int[]{nei[0], temp[nei[0]]});
                    }
                }
            }

            dist = temp;
            level++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}