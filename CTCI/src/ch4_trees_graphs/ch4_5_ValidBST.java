package ch4_trees_graphs;

import java.util.ArrayList;

public class ch4_5_ValidBST {

   /*
    * Implement a function to check if a binary tree is a binary search tree.
    */
   // see Company/google/ValidateBSTWithDuplicates
   public static void main(String[] args) {
      int[] arr = new int[]{3,3,3,7, 9, 14, 23, 32};
      TreeNode root = new TreeNode(arr);
      System.out.println(root.printTree());
      System.out.println(isBST(root));
      System.out.println(isBST2(root));
   }
   
   // min-max solution, left <= root < right
   public static boolean isBST(TreeNode root){
      return minimax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   } 
   public static boolean minimax(TreeNode root, int min, int max){
      if (root == null)
         return true;
      if (root.val <= min || root.val > max) // pay attention to <= and > here
         return false;
      return minimax(root.left, min, root.val) && minimax(root.right, root.val, max);
   }
   
   // get the in-order traversal array and check whether it's in ascending order 
   // doesn't work when there're duplicate values in the BST
   // left < root < right
   public static boolean isBST2(TreeNode root){
      ArrayList<TreeNode> node_arr = new ArrayList<TreeNode>();
      inorderTraversal(root, node_arr);
      for (int i = 1; i < node_arr.size(); i++){
         if (node_arr.get(i).val <= node_arr.get(i-1).val)
            return false;
      }
      return true;
   }
   public static void inorderTraversal(TreeNode root, ArrayList<TreeNode> node_arr){
      if (root == null)
         return;
      inorderTraversal(root.left, node_arr);
      node_arr.add(root);
      inorderTraversal(root.right, node_arr);
   }

}
