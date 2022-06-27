// 1. **Right/Left view of binary tree**

// **Problem Statement:** Given a Binary Tree, find the **Right/Left view** of it. The right view of a Binary Tree is a set of nodes visible when the tree is viewed from the **right** side. The left view of a Binary Tree is a set of nodes visible when the tree is viewed from the **left** side.


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        right(root,res,0);
        return res;
    }
    public void right(TreeNode root,List<Integer> res,int currDepth){
        if(root == null) return;
        if(currDepth == res.size()) res.add(root.val); //since right view is required we traverse root.right first and value is only added if depth is equal ie 1st time only and for left just traverse root.left first
        
        right(root.right,res,currDepth+1);
        right(root.left,res,currDepth+1);
    }
}