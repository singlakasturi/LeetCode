/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp == null) {
                sb.append("n ");
                continue;
            }

            sb.append(temp.val + " ");
            q.offer(temp.left);
            q.offer(temp.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;

        String[] val = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.offer(root);

        for(int i=1;i<val.length-1;i++) {
            TreeNode curr = q.poll();

            if(!val[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                curr.left = left;
                q.offer(left);
            }

            if(!val[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                curr.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));