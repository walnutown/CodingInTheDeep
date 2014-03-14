package groupon;

import lib.TreeNode;

public class FindInorderPredecessorInBST {

   /**
    * Given a binary search tree and current node, find the in-order previous node of current node
    */
   public static void main(String[] args) {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      TreeNode root = new TreeNode(A);
      // TreeNode curr = root.left.left;
      TreeNode curr = root;
      System.out.println(root.printTree());
      System.out.println("root: " + root + " curr: " + curr);
      System.out.println(getPredecessor(root, curr));
   }

   // time: O(lgn); space: O(1)
   public static TreeNode getPredecessor(TreeNode root, TreeNode node) {
      if (node == null)
         return null;
      if (node.left != null)
         return getTreeMax(root);
      TreeNode parent = node.parent, curr = node;
      while (parent != null && parent.left == curr) { // trace back until on the right subtree
         parent = parent.parent;
         curr = curr.parent;
      }
      return parent;
   }

   public static TreeNode getTreeMax(TreeNode root) {
      if (root == null)
         return null;
      TreeNode p = root;
      while (p.right != null)
         p = p.right;
      return p;
   }

}
