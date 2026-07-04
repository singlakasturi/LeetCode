class Solution {

    public void bfs(char[][] board, int i, int j, boolean[][] vis, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] node = q.poll();

            for(int k=0;k<4;k++) {
                int newR = node[0] + dir[k][0];
                int newC = node[1] + dir[k][1];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || vis[newR][newC] || board[newR][newC] != 'O')
                    continue;

                q.offer(new int[]{newR, newC});
                vis[newR][newC] = true;
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            if(board[i][0] == 'O' && !vis[i][0])
                bfs(board, i, 0, vis, n, m);
            if(board[i][m-1] == 'O' && !vis[i][m-1])
                bfs(board, i, m-1, vis, n, m);
        }

        for(int j=0;j<m;j++) {
            if(board[0][j] == 'O' && !vis[0][j])
                bfs(board, 0, j, vis, n, m);
            if(board[n-1][j] == 'O' && !vis[n-1][j])
                bfs(board, n-1, j, vis, n, m);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}