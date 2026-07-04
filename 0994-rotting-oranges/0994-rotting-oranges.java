class Node {
    int i, j, t;

    public Node(int i, int j, int t) {
        this.t = t;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Node(i, j, 0));
                }
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return 0;

        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i=0;i<4;i++) {
                int newR = node.i + dirR[i];
                int newC = node.j + dirC[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || grid[newR][newC] != 1)
                    continue;

                grid[newR][newC] = 2;
                fresh--;

                if(fresh == 0)
                    return node.t + 1;

                q.offer(new Node(newR, newC, node.t + 1));
            }
        }

        return -1;
    }
}