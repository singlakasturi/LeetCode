class Solution {

    public void bfs(int i, int j, char[][] grid, int n, int m, boolean[][] vis) {
        vis[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while(!q.isEmpty()) {
            int[] node = q.poll();

            for(int d=0;d<4;d++) {
                int newR = node[0] + dir[d][0];
                int newC = node[1] + dir[d][1];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || vis[newR][newC] || grid[newR][newC] != '1')
                    continue;

                q.offer(new int[]{newR, newC});
                vis[newR][newC] = true;
            }

        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, grid, n, m, vis);
                }
            }
        }

        return ans;
    }
}