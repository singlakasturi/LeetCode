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

    public TreeNode right(TreeNode left) {
        while(left.right != null) {
            left = left.right;
        }

        return left;
    }

    public TreeNode solve(TreeNode root) {
        if(root.left == null)
            return root.right;
        if(root.right == null)
            return root.left;

        TreeNode curr = root;

        TreeNode right = root.right;
        TreeNode rightMost = right(root.left);

        rightMost.right = right;

        return curr.left;
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