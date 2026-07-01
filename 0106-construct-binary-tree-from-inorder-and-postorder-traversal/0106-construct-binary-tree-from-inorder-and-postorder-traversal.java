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

    HashMap<Integer, Integer> mappy = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;
        int m = postorder.length;

        if(inorder == null || postorder == null || n != m)
            return null;

        for(int i=0;i<n;i++)
            mappy.put(inorder[i], i);

        return solve(inorder, postorder, 0, n-1, 0, m-1);
    }

    public TreeNode solve(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe)
            return null;

        TreeNode node = new TreeNode(postorder[pe]);
        int indexInInorder = mappy.get(node.val);
        int numOfNodesInLeftSubTree = indexInInorder - is;

        node.left = solve(inorder, postorder, is, indexInInorder - 1, ps, ps + numOfNodesInLeftSubTree - 1);
        node.right = solve(inorder, postorder, indexInInorder + 1, ie, ps + numOfNodesInLeftSubTree, pe-1);

        return node;
    }
}