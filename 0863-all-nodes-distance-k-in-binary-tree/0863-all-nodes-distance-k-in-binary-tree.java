/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> ans = new ArrayList<>();

    public void collectDown(TreeNode node, int k) {
        if(node == null || k < 0)
            return ;
        
        if(k == 0) {
            ans.add(node.val);
            return ;
        }

        collectDown(node.left, k-1);
        collectDown(node.right, k-1);
    }

    public int solve(TreeNode root, TreeNode target, int k ){
        if(root == null)
            return -1;

        if(root == target) {
            collectDown(root, k);
            return 0;
        } 

        int left = solve(root.left, target, k);
        if(left != -1) {
            if(left + 1 == k) {
                ans.add(root.val);
            }
            else
                collectDown(root.right, k - left - 2);

            return left + 1;
        }

        int right = solve(root.right, target, k);

        if(right != -1) {
            if(right + 1 == k) {
                ans.add(root.val);
            }
            else
                collectDown(root.left, k - right - 2);

            return right+1;
        }

        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        solve(root, target, k);
        return ans;
    }
}