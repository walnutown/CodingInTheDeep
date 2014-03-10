package ch4_trees_graphs;

public class ch4_7_FindLowestCommonAncestor {

   /**
    * Design an algorithm to find the Lowest common ancestor of two nodes in a binary tree
    * Avoid sorting additional nodes in a data structure
    */
   public static void main(String[] args) {
      int[] arr = new int[] { 1, 3, 5, 7, 9, 14, 23, 32 };
      TreeNode root = new TreeNode(arr);
      TreeNode a = root.left;
      TreeNode b = root.left;
      System.out.println(root.printTree());
      System.out.println("Node a: " + a);
      System.out.println("Node b: " + b);
      System.out.println("First Common Ancestor: " + findFirstCommonAncestor(root, a, b));
   }

   // here, we assume that all node values are unique
   // we find a node if its value is equal to the target
   // time: O(n); space: stack
   public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
      if (root == null)
         return null;
      if (root == a || root == b)
         return root;
      TreeNode left = findFirstCommonAncestor(root.left, a, b);
      TreeNode right = findFirstCommonAncestor(root.right, a, b);
      if (left != null && right != null)
         return root;
      return left != null ? left : right;
   }

   // if this is a BST, we could modify the find operation for the two nodes and see where the paths
   // diverge
   // Lowest Common Ancestor in BST, time: O(n); space: O(1)
   public static TreeNode findLCA(TreeNode root, int a, int b) {
      if (root == null)
         return null;
      while (root != null) {
         if (a > root.val && b > root.val)
            root = root.right;
         else if (a < root.val && b < root.val)
            root = root.left;
         else
            break;
      }
      return root;
   }
}
