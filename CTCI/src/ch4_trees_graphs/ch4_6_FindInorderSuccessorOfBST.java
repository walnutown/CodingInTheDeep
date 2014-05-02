package ch4_trees_graphs;

import org.junit.Test;

public class ch4_6_FindInorderSuccessorOfBST {

   /**
    * Write an algorithm to find the 'next' node (i.e, in-order successor) of
    * a given node in a BST. You may assume that each node has a link to its parent.
    */

   // Two cases:
   // [1] has right subtree, find the min in right subtree
   // [2] no right subtree, go up the tree until on left branch
   // time: O(lgn); space: O(1)
   public TreeNode findInorderSuccessor(TreeNode root, TreeNode n) {
      if (n == null)
         return null;
      // has right subtree
      if (n.right != null)
         return getTreeMin(n.right);
      // track back until on the left subtree of parent node or to the root
      TreeNode curr = n;
      while (curr.parent != null && curr.parent.right == curr) {
         curr = curr.parent;
      }
      return curr.parent;
   }

   private TreeNode getTreeMin(TreeNode root) {
      if (root == null)
         return null;
      TreeNode p = root;
      while (p.left != null) {
         p = p.left;
      }
      return p;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 1, 3, 5, 7, 9, 14, 23, 32 };
      TreeNode root = new TreeNode(arr);
      TreeNode n = root.right.right.right;
      System.out.println(root.printTree());
      System.out.println(n);
      System.out.println(findInorderSuccessor(root, n));
   }

}
