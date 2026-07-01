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

    int i = 0, p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int stop) {

        int n = inorder.length;

        if(p == n) {
            return null;
        }
        if(inorder[i] == stop) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = solve(preorder, inorder, node.val);
        node.right = solve(preorder, inorder, stop);

        return node;
    }
}