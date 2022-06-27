// Bottom view of a Binary Tree


class Pair{
    int level;
    BinaryTreeNode node;
    Pair(BinaryTreeNode node,int level){
        this.level = level;
        this.node = node;
    }
}
public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int line = it.level;
            BinaryTreeNode temp = it.node;
            map.put(line,temp.val); //only difference in 2 problems keeps updating
so at end last vales are there 
            if(temp.left != null) q.add(new Pair(temp.left,line-1));
            if(temp.right != null) q.add(new Pair(temp.right,line+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}