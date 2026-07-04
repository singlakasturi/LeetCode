class Solution {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void bfs(int[][] grid, int i, int j, int n, int m, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;

        while(!q.isEmpty()) {
            int[] node = q.poll();

            for(int k=0;k<4;k++) {
                int newR = node[0] + dir[k][0];
                int newC = node[1] + dir[k][1];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || vis[newR][newC] || grid[newR][newC] != 1)
                    continue;

                q.offer(new int[]{newR, newC});
                vis[newR][newC] = true;
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            if(grid[i][0] == 1 && !vis[i][0])
                bfs(grid, i, 0, n, m, vis);
            if(grid[i][m-1] == 1 && !vis[i][m-1])
                bfs(grid, i, m-1, n, m, vis);
        }

        for(int j=0;j<m;j++) {
            if(grid[0][j] == 1 && !vis[0][j])
                bfs(grid, 0, j, n, m, vis);
            if(grid[n-1][j] == 1 && !vis[n-1][j])
                bfs(grid, n-1, j, n, m, vis);
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