package ch4_trees_graphs;

public class ch4_5 {

   /*
    * Implement a function to check if a binary tree is a binary search tree.
    */
   public static void main(String[] args) {
      int[] arr = new int[]{50,3,5,7, 9, 14, 23, 32};
      TreeNode root = buildTree(arr, 0, arr.length-1);
      System.out.println(isBST(root));
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
   
   public static boolean isBST(TreeNode root){
      if (root == null)
         return true;
      if (root.left != null && root.left.val >= root.val)
         return false;
      if (root.right != null && root.right.val <= root.val)
         return false;
      return isBST(root.left) && isBST(root.right);
   }

}
