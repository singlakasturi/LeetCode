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

    HashMap<Integer, TreeNode> mappy = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    public boolean solve(TreeNode root, long min, long max) {
        if(root == null)
            return true;

        if(root.val <= min || root.val >= max)
            return false;

        if(root.left != null && mappy.containsKey(root.left.val)) {
            root.left = mappy.get(root.left.val);
            mappy.remove(root.left.val);
        }

        if(root.right != null && mappy.containsKey(root.right.val)) {
            root.right = mappy.get(root.right.val);
            mappy.remove(root.right.val);
        }

        return solve(root.left, min, root.val) && solve(root.right, root.val, max);
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        
        for(TreeNode tree : trees) {
            mappy.put(tree.val, tree);
            if(tree.left != null)
                set.add(tree.left.val);
            if(tree.right != null)
                set.add(tree.right.val);
        }

        TreeNode root = null;

        for(TreeNode tree : trees) {
            if(!set.contains(tree.val)) {
                root = tree;
                break;
            }
        }

        if(root == null)
            return null;
        
        mappy.remove(root.val);
        
        if(!solve(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;
        if(!mappy.isEmpty())
            return null;

        return root;

    }
}