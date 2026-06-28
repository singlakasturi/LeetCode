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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int ans = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;


            for(int i=0;i<size;i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.getKey();
                int ind = p.getValue();

                if(i == 0)
                    first = ind;
                if(i == size-1)
                    last = ind;

                if(node.left != null)
                    q.offer(new Pair(node.left, ind*2 + 1));
                if(node.right != null)
                    q.offer(new Pair(node.right, ind*2 + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}