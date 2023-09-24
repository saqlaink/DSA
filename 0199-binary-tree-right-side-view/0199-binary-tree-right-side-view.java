class Solution {
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     right(root,res,0);
    //     return res;
    // }
    // public void right(TreeNode root,List<Integer> res,int currDepth){
    //     if(root == null) return;
    //     if(currDepth == res.size()) res.add(root.val); //since right view is required we traverse root.right first and value is only added if depth is equal ie 1st time only and for left just traverse root.left first
    //     right(root.right,res,currDepth+1);
    //     right(root.left,res,currDepth+1);
    // }
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        right(root,res,0);
        return res;
    }
    public void right(TreeNode root,List<Integer> res,int currDepth){
        if(root == null) return;
        if(currDepth == res.size()) res.add(root.val);
        right(root.right,res,currDepth+1);
        right(root.left,res,currDepth+1);
    }
}