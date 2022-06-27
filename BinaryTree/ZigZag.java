// 1. **Zig Zag Traversal Of Binary Tree**

// **Problem Statement:** Given the root of a binary tree, return the zigzag level order traversal of Binary Tree. (i.e., from left to right, then right to left for the next level and alternate between).

// **Time Complexity: O(N)**

// **Space Complexity: O(N)**


public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null ) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>(size);
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(leftToRight == true) row.add(node.val);
                else row.add(0,node.val);
                    
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            leftToRight = !leftToRight;
            res.add(row);
        }
        return res;
    }