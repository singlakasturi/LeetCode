class Solution {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] grid, int i, int j, int n, int m, boolean[][] vis) {
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] != 1)
            return ;

        vis[i][j] = true;

        for(int k=0;k<4;k++)
            dfs(grid, i+dir[k][0], j+dir[k][1], n, m, vis);
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            if(grid[i][0] == 1 && !vis[i][0])
                dfs(grid, i, 0, n, m, vis);
            if(grid[i][m-1] == 1 && !vis[i][m-1])
                dfs(grid, i, m-1, n, m, vis);
        }

        for(int j=0;j<m;j++) {
            if(grid[0][j] == 1 && !vis[0][j])
                dfs(grid, 0, j, n, m, vis);
            if(grid[n-1][j] == 1 && !vis[n-1][j])
                dfs(grid, n-1, j, n, m, vis);
        }

        int ans = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && grid[i][j] == 1)
                    ans++;
            }
        }

        return ans;

    }
}