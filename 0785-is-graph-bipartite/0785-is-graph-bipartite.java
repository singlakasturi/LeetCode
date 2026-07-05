class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];

        for(int i=0;i<n;i++) {

            if(color[i] != 0)
                continue;

            Queue<Integer> q = new LinkedList<>();
             
            q.offer(i);
            color[i] = 1;

            while(!q.isEmpty()) {
                int node = q.poll();

                for(int v : graph[node]) {
                    if(color[v] == 0) {
                        color[v] = -color[node];
                        q.offer(v);
                    }
                    else if(color[v] == color[node])
                        return false;
                }
            }

        }

        return true;
    }
}