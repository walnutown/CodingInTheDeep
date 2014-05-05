package facebook;

import lib.TreeNode;

import org.junit.Test;

public class TrimBinarySearchTree {

   /**
    * Given a Binary Search Tree (BST) and a range [min, max], remove all nodes which are outside
    * the
    * given range. The modified tree should also be BST
    */
   
   // http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
   
   // Recursion
   // 3 cases:
   // [1] root.val < min; [2] root.val > max; [3] min<root.val<max
   public TreeNode trim(TreeNode root, int min, int max) {
      if (root == null)
         return null;
      if (root.val < min)
         return trim(root.right, min, max);
      if (root.val > max)
         return trim(root.left, min, max);
      root.left = trim(root.left, min, max);
      root.right = trim(root.right, min, max);
      return root;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,2,3,4,5,6,7,8,9};
      TreeNode root = new TreeNode(A);
      System.out.println(root.printTree());
      System.out.println(trim(root, 3, 8).printTree());
   }
}
