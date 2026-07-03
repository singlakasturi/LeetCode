class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                ans++;
                vis[i] = true;
                
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    for(int j=0;j<n;j++) {
                        if(isConnected[curr][j] == 1 && !vis[j]) {
                            q.offer(j);
                            vis[j] = true; 
                        }
                    }
                }
            }
        }

        return ans;
    }
}