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

    int i = 0;

    public TreeNode solve(int[] preorder, int max) {
        if(i == preorder.length || preorder[i] > max)
            return null;
        
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = solve(preorder, node.val);
        node.right = solve(preorder, max);

        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MAX_VALUE);
    }
}