package ch17_moderate;

import org.junit.Test;

public class ch17_13_FlattenBinaryTreeToLinkedList2 {

   /**
    * Consider a simple node-like data structure called BiNode, which has pointers to two other
    * nodes. The data structure BiNode could be used to represent both a binary tree (where node1 is
    * the left node an node2 is the right node) or doubly linked list (where node1 is the previous
    * node and ndoe2 is the next node), Implement a method to convert a binary tree
    * (implemented with BiNode) into a doubly linked list. The values should be kept in order and
    * the operation should be performed in place.
    * eg,
    *       3
    *   1       5
    * 0   2   4   6
    * 0<->1<->2<->3<->4<->5<->6
    */

   public class BiNode {
      int value;
      BiNode node1;
      BiNode node2;

      public BiNode(int value) {
         this.value = value;
      }

      public String toString() {
         return value + " ";
      }
   }

   // similar to leetcode -- FlaternBinaryTreeToLinkedList
   // The difference lies in the order of the list, in-order or pre-order

   // Inorder traverse the binary tree and maintain the previous node to
   // connect list
   // time: O(n); space: recursive stack
   BiNode prev;

   public BiNode convertBinaryTreeToDoublyLinkedList(BiNode root) {
      if (root == null || root.node1 == null && root.node2 == null)
         return root;
      prev = null;
      converter(root);
      BiNode head = root;
      // track back to find the head of the doublyLinkedList
      while (head.node1 != null)
         head = head.node1;
      return head;
   }

   public void converter(BiNode node) {
      if (node == null)
         return;
      converter(node.node1);
      if (prev != null) {
         prev.node2 = node;
         node.node1 = prev;
      }
      prev = node;
      converter(node.node2);
   }
   
   

   // PostOrder traverse the binary tree, and use a wrapper class to hold the head and tail of the
   // sub list
   // time: O(n); space: O(n)
   public BiNode convertBinaryTreeToDoublyLinkedList2(BiNode root) {
      if (root == null || root.node1 == null && root.node2 == null)
         return root;
      return converter2(root).head;
   }

   public WrapperNode converter2(BiNode node) {
      if (node == null)
         return null;
      WrapperNode left = converter2(node.node1);
      WrapperNode right = converter2(node.node2);
      if (left != null)
         connect(left.tail, node);
      if (right != null)
         connect(node, right.head);
      WrapperNode ret = new WrapperNode();
      ret.head = left == null ? node : left.head;
      ret.tail = right == null ? node : right.tail;
      return ret;
   }

   public void connect(BiNode l, BiNode r) {
      l.node2 = r;
      r.node1 = l;
   }

   public class WrapperNode {
      BiNode head;
      BiNode tail;

      public WrapperNode() {

      }

      public WrapperNode(BiNode head, BiNode tail) {
         this.head = head;
         this.tail = tail;
      }
   }

   @Test
   public void test() {
      BiNode root = new BiNode(3);
      root.node1 = new BiNode(1);
      root.node1.node1 = new BiNode(0);
      root.node1.node2 = new BiNode(2);
      root.node2 = new BiNode(5);
      root.node2.node1 = new BiNode(4);
      root.node2.node2 = new BiNode(6);
      // BiNode newRoot = convertBinaryTreeToDoublyLinkedList(root);
      BiNode newRoot = convertBinaryTreeToDoublyLinkedList2(root);
      while (newRoot != null) {
         System.out.print(newRoot);
         newRoot = newRoot.node2;
      }
   }

}
