class Solution {
    public List<List<Integer>> dp;

    public int solve(int i, int j, List<List<Integer>> trianlge, int n) {
        if(i == n-1)
            return trianlge.get(i).get(j);

        if(j > i || i >= n)
            return Integer.MAX_VALUE;

        if(dp.get(i).get(j) != -1)
            return dp.get(i).get(j);

        int d = trianlge.get(i).get(j) + solve(i+1, j, trianlge, n);
        int dg = trianlge.get(i).get(j) + solve(i+1, j+1, trianlge, n);

        dp.get(i).set(j, Math.min(d, dg));
        return dp.get(i).get(j);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new ArrayList<>();

        for(int i=1;i<=n;i++)
            dp.add(new ArrayList<>(Collections.nCopies(i, -1)));

        return solve(0, 0, triangle, n);    
    }
}