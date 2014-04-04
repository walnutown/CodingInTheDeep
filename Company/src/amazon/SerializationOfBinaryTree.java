package amazon;

import java.util.ArrayList;

import lib.ListNode;
import lib.TreeNode;

import org.junit.Test;

public class SerializationOfBinaryTree {

   /*
    * Design an algorithm and write code to serialize and deserialize a binary tree.
    * Writing the tree to a file is called "serialization" and reading back from the
    * file to reconstruct the exact same binary tree is "deserialization".
    * Sol1:
    * <1> do preorder traversal to get the serialized array (in-order and post-order not work here)
    * <2> use '#' to represent null node
    * time: O(n); space: worst case O(2n)
    * Sol2:
    * <1> use two arrays: inorder + postorder/preorder
    * <2> need the prerequisite: no duplicate values in tree
    * time: O(n); space: average case O(2n)
    * Sol3:
    * <1> use the way of storing a heap, for node with index i, left child is 2*i+1, right child is
    * 2*i+2. -1 is used to mark the null node. This solution will waste a lot of space if the tree
    * is not balanced, think of the worst case (a chaining tree)
    * time: O(n); space: worst case O(2^n)
    */

   // below is the serialization and de-serialization of Sol1
   // serialization, time: O(n); space: O(n)
   public ArrayList<String> serializationOfBinaryTree1(TreeNode root) {
      ArrayList<String> res = new ArrayList<String>();
      serialize(root, res);
      return res;
   }

   public void serialize(TreeNode root, ArrayList<String> res) {
      if (root == null) {
         res.add("#");
         return;
      }
      res.add(root.val + "");
      serialize(root.left, res);
      serialize(root.right, res);
   }

   // deserialization
   // pre-order traversal and maintain the index of current element in serialized array
   // time: O(n)
   private int index = 0;

   public TreeNode deserializationOfBinaryTree1(ArrayList<String> arr) {
      if (arr == null || arr.size() == 0)
         return null;
      return deserialize(arr);
   }

   public TreeNode deserialize(ArrayList<String> arr) {
      if (index > arr.size())
         return null;
      String val = arr.get(index++);
      TreeNode node = null;
      if (val.equals("#"))
         return node;
      node = new TreeNode(Integer.parseInt(val));
      node.left = deserialize(arr);
      node.right = deserialize(arr);
      return node;
   }

   // conversion between ListNode and TreeNode
   // assume all the value of TreeNode are positive and we use 0 to represent null node
   ListNode p;

   public ListNode serializationOfBinaryTree2(TreeNode root) {
      ListNode dum = new ListNode(0);
      p = dum;
      s(root);
      return dum.next;
   }

   private void s(TreeNode node) {
      if (node == null) {
         p.next = new ListNode(0);
         p = p.next;
         return;
      }
      p.next = new ListNode(node.val);
      p = p.next;
      s(node.left);
      s(node.right);
   }

   ListNode h;

   public TreeNode deserializationOfBinaryTree2(ListNode head) {
      h = head;
      return ds();
   }

   private TreeNode ds() {
      if (h == null)
         return null;
      if (h.val == 0) {
         h = h.next;
         return null;
      }
      TreeNode node = new TreeNode(h.val);
      h = h.next;
      node.left = ds();
      node.right = ds();
      return node;
   }

   @Test
   public void test1() {
      TreeNode root = new TreeNode(new int[] { 1, 2, 3, 4, 5 });
      System.out.println(root.printTree());
      ArrayList<String> res = serializationOfBinaryTree1(root);
      System.out.println(res);
      System.out.println(deserializationOfBinaryTree1(res).printTree());
   }

   @Test
   public void test2() {
      TreeNode root = new TreeNode(new int[] { 1, 2, 3, 4, 5 });
      System.out.println(root.printTree());
      ListNode head = serializationOfBinaryTree2(root);
      System.out.println(head.printList());
      System.out.println(deserializationOfBinaryTree2(head).printTree());
   }

}
