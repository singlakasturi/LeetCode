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

    public int count(TreeNode root) {
        if(root == null)
            return 0;

        int left = count(root.left);
        int right = count(root.right);

        return 1  + left + right;
    }

    public int kthSmallest(TreeNode root, int k) {

        if(root == null)
            return -1;
        
        int left = count(root.left);
        int right = count(root.right);

        if(left == k-1)
            return root.val;
        else if(left < k-1)
            return kthSmallest(root.right, k - left - 1);
        else
            return kthSmallest(root.left, k);

    }
}