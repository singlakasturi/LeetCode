class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 0;
        int ans = 0;

        for(int i=0;i<n;i++) {
            if(ans == 0 || points[i][0] > arrow) {
                ans++;
                arrow = points[i][1];
            }
        }

        return ans;
    }
}