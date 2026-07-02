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

    public boolean solve(TreeNode root, long min, long max) {
        if(root == null)
            return true;

        boolean left = solve(root.left, min, root.val);
        boolean right = solve(root.right, root.val, max);

        return left && right && root.val < max && root.val > min;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}