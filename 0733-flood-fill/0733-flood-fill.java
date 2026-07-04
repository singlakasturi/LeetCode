class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int ori = image[sr][sc];
        if(ori == color)
            return image;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
    
        int[] dirR = {0, 1, 0, -1};
        int[] dirC = {-1, 0, 1, 0};

        while(!q.isEmpty()) {
            int[] node = q.poll();

            for(int i=0;i<4;i++) {
                int newR = node[0] + dirR[i];
                int newC = node[1] + dirC[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || image[newR][newC] != ori)
                    continue;

                q.offer(new int[]{newR, newC});
                image[newR][newC] = color;
            }
        }

        return image;
    }
}