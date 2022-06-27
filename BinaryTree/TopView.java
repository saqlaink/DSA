// 1. **Top view of a Binary Tree**

// **Problem Statement:** Given below is a binary tree. The task is to print the top view of the binary tree. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.


class Pair{
    int level;
    BinaryTreeNode node;
    Pair(BinaryTreeNode node,int level){
        this.level = level;
        this.node = node;
    }
}
public class Solution {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int line = it.level;
            BinaryTreeNode temp = it.node;
            if(map.get(line) == null) map.put(line,temp.val);
            if(temp.left != null) q.add(new Pair(temp.left,line-1));
            if(temp.right != null) q.add(new Pair(temp.right,line+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}