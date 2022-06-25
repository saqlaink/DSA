class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return helper(root,res);
    }
    public List<Integer> helper(TreeNode root,List<Integer> res){
        if(root != null){
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res);
        }
        return res;
    }
}