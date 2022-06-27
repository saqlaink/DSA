// 1. **Check if two trees are identical**

// **Time Complexity: O(N)**. Reason: We are doing a tree traversal.

// **Space Complexity: O(N)** Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).


static boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;

        return ((node1.data == node2.data) && isIdentical(node1.left, node2.left)
								 && isIdentical(node1.right, node2.right));
    }