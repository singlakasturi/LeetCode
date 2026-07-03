class Solution {

    public void dfs(int[][] isConnected, int n, boolean[] vis) {
        vis[n] = true;

        for(int i=0;i<isConnected.length;i++) {
            if(isConnected[n][i] == 1 && !vis[i])
                dfs(isConnected, i, vis);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;

        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                ans++;
                dfs(isConnected, i, vis);
            }
        }

        return ans;
    }
}