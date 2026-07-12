class Solution {

    Integer[][] dp;

    int solve(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j)
                + Math.min(solve(i + 1, j, triangle),
                           solve(i + 1, j + 1, triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new Integer[n][n];

        return solve(0, 0, triangle);
    }
}