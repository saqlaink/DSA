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
// class Solution {
//     // public boolean isValidBST(TreeNode root) {
//     //     return check(root,Long.MAX_VALUE,Long.MIN_VALUE);
//     // }
//     // public boolean check(TreeNode root,long max,long min){
//     //     if(root == null) return true;
//     //     if(root.val <= min || root.val >= max) return false;
//     //     return check(root.left,root.val,min) && check(root.right,max,root.val);
//     // }
// }
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    public boolean valid(TreeNode root,long maxVal,long minVal){
        if(root == null) return true;
        if(root.val <= minVal || root.val >= maxVal) return false;
        return valid(root.left,root.val,minVal) && valid(root.right,maxVal,root.val);
    }
}