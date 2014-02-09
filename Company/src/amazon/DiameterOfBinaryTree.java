package amazon;

import lib.TreeNode;

public class DiameterOfBinaryTree {

   /**
    * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
    * between two leaves in the tree
    * 
    * Simpler version of leetcode/BinaryTreeMaxPathSum
    */
   // try the cases in https://www.interviewstreet.com/recruit/test/view/sample/4c30cc1084e03/?randhash=81123
   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.left.left.left = new TreeNode(5);
      root.left.right.right = new TreeNode(6);
      System.out.println(root.printTree());
      System.out.println(getDiameter1(root));
      System.out.println(getDiameter2(root));
   }
   // use global variable
   private static int diameter = Integer.MIN_VALUE;
   public static int getDiameter1(TreeNode root){
      if (root==null)   return 0;
      getHeight1(root);
      return diameter;
   }
   public static int getHeight1(TreeNode node){
      if (node==null)   return 0;
      diameter = Math.max(diameter, getHeight1(node.left)+getHeight1(node.right)+1);
      System.out.println(diameter);
      return Math.max(getHeight1(node.left), getHeight1(node.right))+1;
   }
  /*------------------------------------------------------------------*/ 
   // get diameter and height of subtree at the same time
   public static int getDiameter2(TreeNode root){
      return d(root, new int[]{0});
   }
   
   public static int d(TreeNode node, int[] height){
      if (node==null){
         height[0] = 0;
         return 0;
      }
      int[] lh = {0}, rh={0};
      int ld = d(node.left, lh);
      int rd = d(node.right, rh);
      height[0] = Math.max(lh[0], rh[0])+1;
      return Math.max(Math.max(ld,rd), lh[0]+rh[0]+1);
   }

}
