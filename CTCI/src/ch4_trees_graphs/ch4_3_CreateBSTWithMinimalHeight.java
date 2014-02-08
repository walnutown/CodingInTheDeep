package ch4_trees_graphs;

public class ch4_3_CreateBSTWithMinimalHeight {

   /*
    * Given a sorted (increasing order) array with unique integer elements, write an 
    * algorithm to create a binary search tree with minimal height
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1, 3, 5, 7, 9};
      System.out.println(buildTree(arr, 0, arr.length-1).printTree());
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

}
