class Solution {

    int[][] dp;

    public int solve(int i, int j, String a, String b, int n, int m) {
        if (i >= n || j >= m)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (a.charAt(i) == b.charAt(j))
            return dp[i][j] = 1 + solve(i + 1, j + 1, a, b, n, m);

        return dp[i][j] = Math.max(solve(i + 1, j, a, b, n, m), solve(i, j + 1, a, b, n, m));
    }

    public String shortestCommonSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        solve(0, 0, a, b, n, m);

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a.charAt(i) == b.charAt(j)) {
                sb.append(a.charAt(i));
                i++;
                j++;
            } else {
                int down = (i + 1 < n) ? dp[i + 1][j] : 0;
                int right = (j + 1 < m) ? dp[i][j + 1] : 0;

                if (down >= right) {
                    sb.append(a.charAt(i));
                    i++;
                } else {
                    sb.append(b.charAt(j));
                    j++;
                }
            }
        }

        while (i < n)
            sb.append(a.charAt(i++));

        while (j < m)
            sb.append(b.charAt(j++));

        return sb.toString();

    }
}