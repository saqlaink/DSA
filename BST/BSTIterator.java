class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = st.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode node){ //push all elements to left(inorder)
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
}