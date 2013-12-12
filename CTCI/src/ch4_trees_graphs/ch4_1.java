package ch4_trees_graphs;

public class ch4_1 {

   /*
    * Implement a function to check if a binary tree is balanced. 
    * A balanced tree is defined to be a tree such that the heights
    * of the two subtrees of any node never differ by more than one.
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(0);
      root.left = new TreeNode(0);
      root.left.left = new TreeNode(0);
      System.out.println(isBalancedTree(root));
   }
   
   public static boolean isBalancedTree(TreeNode root){
      return getHeight(root) > -1;
   }
   public static int getHeight(TreeNode root){
      if (root == null)
         return 0;
      int lh = getHeight(root.left);
      int rh = getHeight(root.right);
      if (lh == -1 || rh == -1 || Math.abs(lh-rh) > 1)
         return -1;
      return Math.max(lh, rh) + 1;
   }

}
