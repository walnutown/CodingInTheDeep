package facebook;

import java.util.Deque;
import java.util.LinkedList;

import lib.TreeNode;

import org.junit.Test;

public class SinkZerosInBinaryTree {
   /**
    * Sink Zero in Binary Tree. Swap zero value of a node with non-zero value of one of its
    * descendants. So that no node with value zero could be parent of node with non-zero.
    */

   /*
    * Recursion. Sink zeros in child subtree first, and then parent.
    * time: O(n^2); space: O(1)
    */
   public TreeNode sinkZerosInBT(TreeNode root) {
      if (root == null)
         return null;
      root.left = sinkZerosInBT(root.left);
      root.right = sinkZerosInBT(root.right);
      if (root.val == 0) {
         TreeNode node = getLowestNonZeroNode(root);
         swap(root, node);
      }
      return root;
   }

   private void swap(TreeNode root, TreeNode node) {
      int tmp = root.val;
      root.val = node.val;
      node.val = tmp;
   }

   // time: O(n)
   private TreeNode getLowestNonZeroNode(TreeNode node) {
      assert (node != null);
      if ((node.left == null || node.left.val == 0) && (node.right == null || node.right.val == 0))
         return node;
      TreeNode left = getLowestNonZeroNode(node.left);
      if (left == null || left.val == 0)
         return getLowestNonZeroNode(node.right);
      return left;
   }

   /**
    * Basically is a preorder traversal
    * Maintain a double-ended queue to store all the previous zero nodes.
    * If current is a zero-node, push it to the end of deque
    * If current is a non-zero node, swap it with the first zero node in deque, and then
    * push the current node to deque (because it's a zero node now)
    * 
    * time: O(n); space: O(n)
    */
   private Deque<TreeNode> deque;

   public TreeNode sinkZerosInBT2(TreeNode root) {
      if (deque == null)
         deque = new LinkedList<TreeNode>();
      if (root == null)
         return null;
      if (root.val == 0)
         deque.addLast(root);
      else {
         if (!deque.isEmpty()) {
            swap(root, deque.pollFirst());
            deque.addLast(root); // need to push this new zero-node to end of deque
         }
      }
      sinkZerosInBT2(root.left);
      sinkZerosInBT2(root.right);
      if (deque.peekLast() == root)   // there's no non-zero node for us to swap, poll the zero node
         deque.pollLast();
      return root;
   }

   @Test
   public void test() {
      int[] A = new int[] { 0, 1, 0, 0, 4, 0, 5 };
      int[] B = new int[] { 0, 1, 0, 0, 4, 0, 5 };
      TreeNode root = new TreeNode(A);
      TreeNode root2 = new TreeNode(B);
      System.out.println(root.printTree());
      System.out.println(sinkZerosInBT(root).printTree());
      System.out.println(sinkZerosInBT2(root2).printTree());
   }
}
