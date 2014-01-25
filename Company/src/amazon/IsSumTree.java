package amazon;

import lib.TreeNode;

public class IsSumTree {

   /**
    * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in
    * its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be
    * considered as 0. A leaf node is also considered as SumTree.
    * 
    * Following is an example of SumTree.
    * 
    * 26
    * / \
    * 10 3
    * / \ \
    * 4 6 3
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(new int[] { 4, 10, 6, 26, 3, 3 }, new int[] { 26, 10, 4, 6, 3, 3 });
      System.out.println(root.printTree());
      System.out.println(isSumTree(root));
   }

   public static boolean isSumTree(TreeNode root) {
      return getSum(root) != -1;
   }

   public static int getSum(TreeNode node) {
      if (node == null)
         return 0;
      if (node.left==null && node.right==null)  return node.val;
      int lsum = getSum(node.left), rsum = getSum(node.right);
      if (lsum == -1 || rsum == -1 || node.val != lsum + rsum)
         return -1;
      return node.val + lsum + rsum;
   }

}
