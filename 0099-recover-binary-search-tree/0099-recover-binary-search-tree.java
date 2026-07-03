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

    public void fillArr(TreeNode node, int[] arr, int[] ind) {
        if(node == null)
            return ;

        fillArr(node.left, arr, ind);
        arr[ind[0]++] = node.val;
        fillArr(node.right, arr, ind);
    }

    public void swap(TreeNode node, int a, int b, int[] cnt) {
        if(node == null || cnt[0] == 2)
            return ;

        if(node.val == a || node.val == b) {
            node.val = node.val == a ? b : a;
            cnt[0]++;
        }

        swap(node.left, a, b, cnt);
        swap(node.right, a, b, cnt);
    }

    public void recoverTree(TreeNode root) {
        int[] arr = new int[size(root)];
        fillArr(root, arr, new int[]{0});
        int n = arr.length;
        int a = -1, b = -1;

        for(int i=0;i<n-1;i++) {
            if(arr[i] > arr[i+1]) {
                if(a == -1) {
                    a = i;
                }
                b = i+1;
            }
        }

        swap(root, arr[a], arr[b], new int[]{0});
    }
}