class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];


        for(int i=0;i<n;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        
        int[] dirR = {0, 1, 0, -1};
        int[] dirC = {1, 0, -1, 0};

        

        while(!q.isEmpty()) {
            int[] node = q.poll();

            if(node[2] > dist[node[0]][node[1]])
                continue;

            for(int i=0;i<4;i++) {
                int newR = node[0] + dirR[i];
                int newC = node[1] + dirC[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || vis[newR][newC])
                    continue;

                if(node[2] + 1 < dist[newR][newC]) {
                    q.offer(new int[]{newR, newC, node[2] + 1});
                    vis[newR][newC] = true;
                    dist[newR][newC] = node[2] + 1;
                }
            }
        }

        return dist;
    }
}