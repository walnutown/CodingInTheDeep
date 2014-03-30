package amazon;

import java.util.ArrayList;

import lib.TreeNode;

import org.junit.Test;

public class SerializationOfBinaryTree {

   /*
    * Design an algorithm and write code to serialize and deserialize a binary tree.
    * Writing the tree to a file is called "serialization" and reading back from the
    * file to reconstruct the exact same binary tree is "deserialization".
    * 
    * Sol1:
    * <1> do preorder traversal to get the serialized array
    * <2> use '#' to represent null node
    * 
    * Sol2:
    * <1> do BFS level order traversal, use '#' to represent null node
    * <2> refer to Leetcode -- BinaryTreeLevelOrderTraversal
    * 
    * Sol3:
    * <1> use two arrays: inorder and preorder
    * <2> need the prerequisite: no duplicate values in tree
    * 
    * Sol4:
    * <1> use the way of storing a heap, for node with index i, left child is 2*i+1, right child is
    * 2*i+2. -1 is used to mark the null node.
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

   @Test
   public void test() {
      TreeNode root = new TreeNode(new int[] { 1, 2, 3, 4, 5 });
      System.out.println(root.printTree());
      ArrayList<String> res = serializationOfBinaryTree1(root);
      System.out.println(res);
      System.out.println(deserializationOfBinaryTree1(res).printTree());
   }
}
