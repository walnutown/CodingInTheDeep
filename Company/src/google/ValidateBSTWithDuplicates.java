package google;

import lib.TreeNode;

public class ValidateBSTWithDuplicates {

   /**
    * Originally, BST does not allow duplicate keys.
    * How to deal with duplicate keys in a BST?
    * Validate a Binary Search Tree, left<=curr<right
    */

   // strategies for solving duplicate keys in BST
   // Ref: http://stackoverflow.com/questions/16727871/bst-with-duplicates
   // <1> put the duplicate node in left or right subtree (understand how to deal with insert and
   // delete)
   // <2> store count of duplicates in each node
   // <3> value of the node can be a list to store the nodes with same key

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      System.out.println(root.printTree());

   }

   public static boolean validateBSTWithDuplicates(TreeNode root) {
      return checker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
   // time: O(n)
   public static boolean checker(TreeNode root, int min, int max) {
      if (root == null)
         return true;
      if (root.val <= min || root.val > max)
         return false;
      return checker(root.left, min, root.val) && checker(root.right, root.val, max);
   }

   public static boolean validateBSTWithDuplicates2(TreeNode root) {
      return checker2(root, 0, false, 0, false);
   }
   
   public static boolean checker2(TreeNode root, int min, boolean checkMin, int max, boolean checkMax){
      if (root == null)
          return true;
      if (checkMin && root.val <= min)
          return false;
      if (checkMax && root.val > max)
         return false;
      return checker2(root.left, min, checkMin, root.val, true) && checker2(root.right, root.val, true, max, checkMax);
  }
}
