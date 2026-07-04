class Solution {

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int i, int j, boolean[][] vis, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || board[i][j] != 'O')
            return ;

        vis[i][j] = true;

        for(int k=0;k<4;k++)
            dfs(board, i + dir[k][0], j + dir[k][1], vis, n, m);
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            if(board[i][0] == 'O' && !vis[i][0])
                dfs(board, i, 0, vis, n, m);
            if(board[i][m-1] == 'O' && !vis[i][m-1])
                dfs(board, i, m-1, vis, n, m);
        }

        for(int j=0;j<m;j++) {
            if(board[0][j] == 'O' && !vis[0][j])
                dfs(board, 0, j, vis, n, m);
            if(board[n-1][j] == 'O' && !vis[n-1][j])
                dfs(board, n-1, j, vis, n, m);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}