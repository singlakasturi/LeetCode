class Solution {

    public void dfs(int[][] image, int i, int j, int ori, int n, int m, int color) {
        if(i < 0 || i >= n || j < 0 || j >= m || image[i][j] != ori)
            return ;

        image[i][j] = color;

        dfs(image, i+1, j, ori, n, m, color);
        dfs(image, i-1, j, ori, n, m, color);
        dfs(image, i, j+1, ori, n, m, color);
        dfs(image, i, j-1, ori, n, m, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int ori = image[sr][sc];
        if(ori == color)
            return image;

        dfs(image, sr, sc, ori, n, m, color);

        return image;
    }
}