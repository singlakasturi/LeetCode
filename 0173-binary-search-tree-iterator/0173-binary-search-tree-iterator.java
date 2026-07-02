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
class BSTIterator {

    Deque<TreeNode> dq = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        storeLeftMost(root);
    }

    private void storeLeftMost(TreeNode root) {
        while(root != null) {
            dq.addFirst(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = dq.removeFirst();

        if(node.right != null) {
            storeLeftMost(node.right);
        }

        return node.val;
    }
    
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */