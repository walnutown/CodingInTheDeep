package ch4_trees_graphs;

import org.junit.Test;

public class FindLCAInBST {
   /**
    * Given a binary search tree, find the lowest common ancestor of two given nodes
    */
   
   // Note the following solution cannot handle the case that a or b is not in bst
   
   // if a<curr, b<curr, go left
   // if a>curr, b>curr, go right
   // else, lca
   // time: O(n); space: O(1)
   public TreeNode findLCA(TreeNode root, int a, int b) {
      if (root == null)
         return null;
      while (root != null) {
         if (a > root.val && b > root.val)
            root = root.right;
         else if (a < root.val && b < root.val)
            root = root.left;
         else
            break;
      }
      return root;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 1, 3, 5, 7, 9, 14, 23, 32 };
      TreeNode root = new TreeNode(arr);
      int a = 3, b = 23;
      System.out.println(root.printTree());
      System.out.println("Node a: " + a);
      System.out.println("Node b: " + b);
      System.out.println("First Common Ancestor: " + findLCA(root, a, b));
   }
}
