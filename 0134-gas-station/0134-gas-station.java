class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasC = 0, costC = 0;

        for(int i = 0; i< n ; i++) {
            gasC += gas[i];
            costC += cost[i];
        }

        if(gasC < costC)
            return -1;

        int ans = 0;
        int bank = 0;


        for(int i =0;i<n;i++) {
            bank += gas[i] - cost[i];

            if(bank < 0) {
                ans = i+1;
                bank = 0;
            }
        }

        return ans;
    }
}