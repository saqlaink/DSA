// 1. **Maximum depth of a Binary Tree**

// **Problem Statement:** Find the **Maximum Depth** of Binary Tree. Maximum Depth is the **count of nodes of the longest path** from the ****root node to the leaf node.


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
}