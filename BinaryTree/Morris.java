// Inorder
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){      //last value
                inorder.add(curr.val);
                curr = curr.right;
            }else{                       //left value exists
                TreeNode prev = curr.left; //got to left
                while(prev.right != null && prev.right != curr){ //find right most value which doesnt point to itself 
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr; //create a thread to curr as it points to null
                    curr = curr.left;
                }else{//thread exists
                    prev.right = null; //break the thread
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}