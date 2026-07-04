class Solution {

    public boolean dfs(List<List<Integer>> adj, int i, boolean[] vis, boolean[] dfsVis, int par) {
        vis[i] = true;
        dfsVis[i] = true;

        for(int nei : adj.get(i)) {
            if(!vis[nei]) {
                if(dfs(adj, nei, vis, dfsVis, i))
                    return true;
            }
            else if(dfsVis[nei])
                return true;
        }

        dfsVis[i] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] e : edges)
            adj.get(e[1]).add(e[0]);

        boolean[] vis = new boolean[n];
        boolean[] dfsVis = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                if(dfs(adj, i, vis, dfsVis, -1))
                    return false;
            }
        }

        return true;
    }
}