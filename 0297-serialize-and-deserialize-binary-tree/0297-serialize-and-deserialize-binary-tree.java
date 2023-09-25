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
    private int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDfs(root,list);
        return String.join(",", list);
    }
    private void serializeDfs(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDfs(root.left, list);
        serializeDfs(root.right, list);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDfs(tokens);
    }
    private TreeNode deserializeDfs(String[] tokens){
        String token = tokens[this.i];
        if(token.equals("N")){
            this.i++;
            return null;
        }
        var node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDfs(tokens);
        node.right = deserializeDfs(tokens);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));