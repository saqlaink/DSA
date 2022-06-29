public class Solution {
  static Node prev = null;
    static void flatten(Node  root) {
      if (root == null) return;

      flatten(root . right);
      flatten(root . left);

      root . right = prev;
      root . left = null;
      prev = root;
    }
}