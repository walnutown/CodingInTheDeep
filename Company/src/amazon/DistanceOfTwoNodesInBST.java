package amazon;

import lib.TreeNode;

public class DistanceOfTwoNodesInBST {

   /**
    * Find the distance between two nodes in a BST
    * Sol: 
    * <1> find the lowest common ancestor
    * <2> find the distance between lca and two nodes
    * <3> sum the distance
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(new int[] { 1, 2, 3, 4, 5, 6, 7 });
      TreeNode a = root.left.left;
      TreeNode b = root.left.right;
      System.out.println(root.printTree());
      System.out.println(a);
      System.out.println(b);
      System.out.println(findDistanceOfTwoNodesInBST(root, a, b));
   }

   public static int findDistanceOfTwoNodesInBST(TreeNode root, TreeNode a, TreeNode b) {
      // get lowest common ancestor
      TreeNode lca = null;
      while (root != null) {
         if (root.val > a.val && root.val > b.val)
            root = root.left;
         else if (root.val < a.val && root.val < b.val)
            root = root.right;
         else{
            lca = root;
            break;
         }
      }
      return getDistance(lca, a, 0) + getDistance(lca, b, 0) + 1;
   }
   public static int getDistance(TreeNode lca, TreeNode node, int len){
      if (lca==node)  return len;
      if (lca==null)    return 0;
      if (lca.val < node.val)   return getDistance(lca.right, node, len+1);
      return getDistance(lca.left, node, len+1);
   }
}
