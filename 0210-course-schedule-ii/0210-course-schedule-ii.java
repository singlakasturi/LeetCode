class Solution {
    public int[] findOrder(int n, int[][] edges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        for(int[] e : edges) {
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        int k = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            ans[k++] = node;

            for(int nei : adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        return k != n ? new int[]{} : ans;
    }
}