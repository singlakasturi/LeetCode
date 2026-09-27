class Solution {

    public int bfs(String startGene, String endGene, HashSet<String> set) {
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        vis.add(startGene);
        int ans = 0;
        char[] choices = {'A', 'C', 'G', 'T'};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int s=0;s<size;s++) {
                String str = q.poll();
                
                if(str.equals(endGene))
                    return ans;

                char[] ch = str.toCharArray();

                for(int i=0;i<ch.length;i++) {
                    char original = ch[i];

                    for(char c : choices) {
                        if(original == c)
                            continue;

                        ch[i] = c;
                        String newGene = new String(ch);

                        if(set.contains(newGene) && !vis.contains(newGene)) {
                            vis.add(newGene);
                            q.offer(newGene);
                        }
                    }

                    ch[i] = original;
                }
            }

            ans++;
        }

        return -1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for(String s : bank)
            set.add(s);

        return bfs(startGene, endGene, set);
    }
}