class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counting = new int[n+1];

        for(int i : citations) {
            counting[Math.min(i, n)]++;
        }

        int h = n;
        int papers = counting[h];

        while(papers < h) {
            h--;
            papers += counting[h];
        }

        return h;
    }
}