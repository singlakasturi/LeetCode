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

    List<String> ans = new ArrayList<>();

    public boolean isLeaf(TreeNode node) {

        if(node == null)
            return false;

        if(node.left == null && node.right == null)
            return true;
        
        return false;
    } 

    public void solve(TreeNode node, String s) {
        if(node == null)
            return ;
        
        if(isLeaf(node)) {
            ans.add(s);
            return ;
        }

        if(node.left != null)
            solve(node.left, s + "->" + node.left.val);
        if(node.right != null)
            solve(node.right, s + "->" + node.right.val);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        solve(root, String.valueOf(root.val));
        return ans;
    }
}