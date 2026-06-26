/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> mappy = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();

        q.offer(new Pair(root, new Pair(0, 0)));

        while(!q.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> p =q.poll();

            TreeNode node = p.getKey();
            int x = p.getValue().getKey();
            int y = p.getValue().getValue();

            mappy.computeIfAbsent(x, k -> new TreeMap<>())
                 .computeIfAbsent(y, k -> new ArrayList<>())
                 .add(node.val);

            if(node.left != null)
                q.offer(new Pair(node.left, new Pair(x-1, y+1)));
            if(node.right != null)
                q.offer(new Pair(node.right, new Pair(x+1, y+1)));
        }

        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : mappy.entrySet()) {
            List<Integer> col = new ArrayList<>();

            for(List<Integer> l : entry.getValue().values()) {
                Collections.sort(l);
                col.addAll(l);
            }

            ans.add(col);
        }

        return ans;
    }
}