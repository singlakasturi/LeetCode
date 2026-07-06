class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}};

        while(!q.isEmpty()) {
            int[] node = q.poll();

            if(node[0] == n-1 && node[1] == n-1)
                return node[2];

            for(int k=0;k<8;k++) {
                int newR = node[0] + dir[k][0];
                int newC = node[1] + dir[k][1];

                if(newR < 0 || newR >= n || newC < 0 || newC >= n || grid[newR][newC] == 1)
                    continue;
                
                q.offer(new int[]{newR, newC, node[2] + 1});
                grid[newR][newC] = 1;
            }
        }

        return -1;

    }
}