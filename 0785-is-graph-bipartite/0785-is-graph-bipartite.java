class Solution {

    public boolean dfs(int[][] graph, int node, int[] colors, int color, int n) {
        colors[node] = color;

        for(int v : graph[node]) {
            if(colors[v] == 0) {
                if(!dfs(graph, v, colors, -color, n))
                    return false;
            }
            else if(colors[v] == colors[node])
                return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i=0;i<n;i++) {
            if(color[i] == 0) {
                if(!dfs(graph, i, color, 1, n))
                    return false;
            }
        }

        return true;
    }
}