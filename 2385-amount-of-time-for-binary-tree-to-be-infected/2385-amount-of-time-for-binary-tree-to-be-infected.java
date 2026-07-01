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

    Map<TreeNode, TreeNode> mappy = new HashMap<>();

    public void pop(TreeNode root, TreeNode par) {

        if (root == null)
            return;

        mappy.put(root, par);
        if (root.left != null)
            pop(root.left, root);
        if (root.right != null)
            pop(root.right, root);
    }

    public TreeNode find(TreeNode root, int start) {
        if (root == null)
            return null;

        if (root.val == start)
            return root;

        TreeNode left = find(root.left, start);
        TreeNode right = find(root.right, start);

        return left != null ? left : right;
    }

    public int amountOfTime(TreeNode root, int start) {

        pop(root, null);

        TreeNode st = find(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        int time = 0;
        HashSet<TreeNode> set = new HashSet<>();

        q.offer(st);
        set.add(st);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++)

            {
                TreeNode node = q.poll();
                if (node.left != null && !set.contains(node.left)) {
                    q.offer(node.left);
                    set.add(node.left);
                }
                if (node.right != null && !set.contains(node.right)) {
                    q.offer(node.right);
                    set.add(node.right);
                }
                if (mappy.get(node) != null && !set.contains(mappy.get(node))) {
                    q.offer(mappy.get(node));
                    set.add(mappy.get(node));
                }
            }
            time++;
        }

        return --time;
    }
}