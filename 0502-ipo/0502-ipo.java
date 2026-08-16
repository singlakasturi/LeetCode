class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer[] indices = new Integer[n];

        for(int i=0;i<n;i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(capital[a], capital[b]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int i = 0;

        while(k-- > 0) {
            while(i < n && capital[indices[i]] <= w) {
                pq.offer(profits[indices[i]]);
                i++;
            } 

            if(pq.isEmpty())
                break;

            w += pq.poll();
        }

        return w;
    }
}