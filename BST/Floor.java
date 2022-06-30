public static int floorInBST(TreeNode<Integer> root, int x) {
    int floor = -1;
    while(root != null){
        if(root.data == x){
            floor = x;
            return x;
        }
        if(x>root.data){
            floor = root.data;
            root = root.right;
        }else{
            root = root.left;
        }
    }
    return floor;
}