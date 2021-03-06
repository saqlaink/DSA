class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        int cnt = 0; 
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left; //for largest node.right
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                // inorder.add(node.val);
                cnt++; 
                if(cnt == k) return node.val; 
                node = node.right;  //for largest node.left
            }
        }
        return -1; 
    }
}