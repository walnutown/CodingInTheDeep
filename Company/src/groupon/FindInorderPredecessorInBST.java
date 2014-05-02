package groupon;

import lib.TreeNode;

import org.junit.Test;

public class FindInorderPredecessorInBST {

   /**
    * Given a binary search tree and current node, find the in-order previous node of current node
    */

   // Similar to findInorderSuccessorInBST
   // Two cases:
   // [1] has left subtree, find the max in left subtree
   // [2] no left subtree, go up the tree until on right branch
   // time: O(lgn); space: O(1)
   public TreeNode getPredecessor(TreeNode root, TreeNode node) {
      if (node == null)
         return null;
      if (node.left != null)
         return getTreeMax(node.left);
      TreeNode curr = node;
      while (curr.parent != null && curr.parent.left == curr) { // trace back until on the right subtree
         curr = curr.parent;
      }
      return curr.parent;
   }

   private TreeNode getTreeMax(TreeNode root) {
      if (root == null)
         return null;
      TreeNode p = root;
      while (p.right != null)
         p = p.right;
      return p;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      TreeNode root = new TreeNode(A);
      // TreeNode curr = root.left.left;
      TreeNode curr = root;
      System.out.println(root.printTree());
      System.out.println("root: " + root + " curr: " + curr);
      System.out.println(getPredecessor(root, curr));
   }

}
