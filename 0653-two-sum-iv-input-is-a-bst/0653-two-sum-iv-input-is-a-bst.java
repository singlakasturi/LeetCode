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

    public int size(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + size(root.left) + size(root.right);
    }

    public void fillArr(int[] arr, TreeNode node, int[] ind) {
        if(node == null)
            return ;

        fillArr(arr, node.left, ind);
        arr[ind[0]++] = node.val;
        fillArr(arr, node.right, ind);
    }

    public boolean findTarget(TreeNode root, int k) {
        int[] arr = new int[size(root)];
        fillArr(arr, root, new int[]{0});

        int n = arr.length;
        int l = 0, r = n-1;

        while(l < r) {
            if(arr[l] + arr[r] == k)
                return true;
            else if(arr[l] + arr[r] < k)
                l++;
            else
                r--;
        }

        return false;
    }
}