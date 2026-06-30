class Solution {
    
    boolean check(int[] piles, int h, int mid) {
        int n = piles.length;
        int hours = 0;
        
        for(int i=0;i<n;i++) {
            hours += (int) Math.ceil((double)piles[i]/mid);
                
            if(hours > h)
                return false;
        }
        
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        
        int low = 1, high = 0;
        int ans = -1;
        
        for(int i : piles)
            high = Math.max(i, high);
            
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(check(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        
        return ans;

    }

}