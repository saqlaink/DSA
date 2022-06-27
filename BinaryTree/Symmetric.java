// Check for Symmetrical Binary Tree


class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmHelper(root.left,root.right);
    }
    public boolean isSymmHelper(TreeNode left,TreeNode right){
        if(left == null || right == null){ //either becomes null other should be null as well
            return left == right;
        }
        if(left.val != right.val) return false;
        
        return isSymmHelper(left.left,right.right) && isSymmHelper(left.right,right.left);
    }
}