class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return helper(root,res);
    }
    public List<Integer> helper(TreeNode root,List<Integer> res){
        if(root!=null){
            
            helper(root.left,res);
            helper(root.right,res);
            res.add(root.val);
        }
        return res;
    }
}