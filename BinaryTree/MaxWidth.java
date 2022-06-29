class Pair{
    int num;
    TreeNode node;
    Pair(TreeNode node,int num){
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num; //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0;i<size;i++){
                int currId = q.peek().num - mmin; //avoid integer overflow
                TreeNode node = q.peek().node;
                q.remove();
                if(i == 0) first = currId;
                if(i == size - 1) last = currId;
                if(node.left != null) q.add(new Pair(node.left,currId*2+1));
                if(node.right != null) q.add(new Pair(node.right,currId*2+2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}