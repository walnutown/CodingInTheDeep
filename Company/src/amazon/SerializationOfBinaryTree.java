package amazon;

import java.util.ArrayList;

import lib.TreeNode;

public class SerializationOfBinaryTree {

   /**
    * Design an algorithm and write code to serialize and deserialize a binary tree.
    * Writing the tree to a file is called ‘serialization’ and reading back from the
    * file to reconstruct the exact same binary tree is ‘deserialization’.
    * 
    * Sol1:
    * <1> use '#' to represent null node
    * <2> do preorder traversal to get the serialized array
    * 
    * Sol2:
    * <1> use BFS level order traversal
    * <2> refer to Leetcode -- BinaryTreeLevelOrderTraversal
    * 
    * Sol3:
    * <1> use two arrays: inorder and preorder
    * <2> need the prerequisite: no duplicate vals in tree
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(new int[] { 1, 2, 3, 4, 5 });
      System.out.println(root.printTree());
      ArrayList<String> res = serializationOfBinaryTree1(root);
      System.out.println(res);
      System.out.println(deserializationOfBinaryTree1(res).printTree());
   }

   public static ArrayList<String> serializationOfBinaryTree1(TreeNode root) {
      ArrayList<String> res = new ArrayList<String>();
      serialize(root, res);
      return res;
   }

   public static void serialize(TreeNode root, ArrayList<String> res) {
      if (root == null) {
         res.add("#");
         return;
      }
      res.add(root.val + "");
      serialize(root.left, res);
      serialize(root.right, res);
   }

   // deserialization
   private static int index = 0;

   public static TreeNode deserializationOfBinaryTree1(ArrayList<String> arr) {
      if (arr == null || arr.size() == 0)
         return null;
      return deserialize(arr);
   }

   public static TreeNode deserialize(ArrayList<String> arr) {
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
}
