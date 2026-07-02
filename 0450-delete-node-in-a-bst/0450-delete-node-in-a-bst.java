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

    public TreeNode left(TreeNode left) {
        while(left.left != null)
            left = left.left;

        return left;
    }

    public TreeNode solve(TreeNode node) {
        if(node.left == null)
            return node.right;
        if(node.right == null)
            return node.left;

        TreeNode curr = node;

        TreeNode left = node.left;
        TreeNode leftMost = left(node.right);

        leftMost.left = left;

        return node.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key)
            return solve(root);

        TreeNode node = root;

        while(root != null) {
            if(root.val < key) {
                if(root.right != null && root.right.val == key) {
                    root.right = solve(root.right);
                    break;
                }
                else
                    root = root.right;
            }
            else {
                if(root.left != null && root.left.val == key) {
                    root.left = solve(root.left);
                    break;
                }
                else
                    root = root.left;
            }
        }

        return node;
    }
}