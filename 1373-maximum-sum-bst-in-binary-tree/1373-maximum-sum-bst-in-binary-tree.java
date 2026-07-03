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

class Node {
    boolean BST;
    int min, max, sum;

    public Node(boolean BST, int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.BST = BST;
    }
}

class Solution {

    int ans = 0;

    public Node solve(TreeNode root) {
        if(root == null)
            return new Node(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Node left = solve(root.left);
        Node right = solve(root.right);
 
        if(left.BST && right.BST && root.val > left.max && root.val < right.min) {
            int currSum = root.val + left.sum + right.sum;

            ans = Math.max(ans, currSum);

            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);

            return new Node(true, min, max, currSum);
        }

        return new Node(false, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    } 

    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }
}