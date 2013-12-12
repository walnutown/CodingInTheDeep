package ch4_trees_graphs;

import java.util.ArrayList;

public class ch4_5 {

   /*
    * Implement a function to check if a binary tree is a binary search tree.
    */
   public static void main(String[] args) {
      int[] arr = new int[]{3,3,3,7, 9, 14, 23, 32};
      TreeNode root = new TreeNode(arr);
      System.out.println(root.printTree());
      System.out.println(isBST(root));
      System.out.println(isBST2(root));
   }
   
   public static TreeNode buildTree(int[] arr, int start, int end){
      if (start > end)
         return null;
      int mid = (start + end) >> 1;
      TreeNode root = new TreeNode(arr[mid]);
      root.left = buildTree(arr, start, mid-1);
      root.right = buildTree(arr, mid+1, end);
      return root;
   }
   
   // minimax solution, left <= root < right
   public static boolean isBST(TreeNode root){
      return minimax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   } 
   public static boolean minimax(TreeNode root, int min, int max){
      if (root == null)
         return true;
      if (root.val <= min || root.val > max)
         return false;
      return minimax(root.left, min, root.val) && minimax(root.right, root.val, max);
   }
   
   // in-order traversal and compare, doesn't work when there're duplicate values of node
   // left <= root < right
   public static boolean isBST2(TreeNode root){
      ArrayList<TreeNode> node_arr = new ArrayList<TreeNode>();
      inorderTraversal(root, node_arr);
      for (int i = 1; i < node_arr.size(); i++){
         if (node_arr.get(i).val < node_arr.get(i-1).val)
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
