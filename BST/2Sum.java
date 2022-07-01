public class BSTIterator{
    private Stack<TreeNode> st = new Stack<>(); //reverse -> false: after
    boolean reverse = true;                     //reverse -> true : Before
    public BSTIterator(TreeNode root,boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public int next(){
        TreeNode temp = st.pop();
        if(reverse == false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
    public void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse == true){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root,false); //next
        BSTIterator r = new BSTIterator(root,true); //before
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j == k) return true;
            else if(i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}