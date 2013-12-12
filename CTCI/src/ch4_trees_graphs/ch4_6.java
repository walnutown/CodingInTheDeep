package ch4_trees_graphs;

public class ch4_6 {

   /*
    * Write an algorithm to find the 'next' node (i.e, in-order successor) of 
    * a given node in a BST. You may assume that each node has a link to its parent.
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

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
