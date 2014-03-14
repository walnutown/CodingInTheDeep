package ch4_trees_graphs;

public class ch4_6_FindInorderSuccessorOfBST {

   /*
    * Write an algorithm to find the 'next' node (i.e, in-order successor) of 
    * a given node in a BST. You may assume that each node has a link to its parent.
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1,3,5,7, 9, 14, 23, 32};
      TreeNode root = new TreeNode(arr);
      TreeNode n = root.right.right.right;
      System.out.println(root.printTree());
      System.out.println(n);
      System.out.println(findInorderSuccessor(root, n));
   }
   
   // time: O(lgn); space: O(1)
   public static TreeNode findInorderSuccessor(TreeNode root, TreeNode n){
      if (n == null)
         return null;
      // has right subtree
      if (n.right != null)
         return getTreeMin(n.right);
      // track back until on the left subtree of parent node or to the root 
      TreeNode curr = n, parent = curr.parent;
      while (parent != null && parent.right == curr){
         curr = parent;
         parent = curr.parent;
      }
      return parent;
   }
   
   public static TreeNode getTreeMin(TreeNode root){
      if (root == null)
         return null;
      TreeNode p = root;
      while (p.left != null){
         p = p.left;
      }
       return p;        
   }
}
