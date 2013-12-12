package ch4_trees_graphs;

import java.util.List;

public class ch4_9 {

   /*
    * Given a binary tree, to print all paths which sum to a given value.
    * The path does not need to start or end at the root or a leaf
    */
   public static void main(String[] args) {
      int[] arr1 = new int[]{50,3,5,7, 9, 14, 23, 32};
      int[] arr2 = new int[]{50,3,5};
      TreeNode t1 = buildTree(arr1, 0, arr1.length-1);
      TreeNode t2 = buildTree(arr2, 0, arr2.length-1);
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
   
   public static List<TreeNode> getPaths(TreeNode root){
      
   }

}
