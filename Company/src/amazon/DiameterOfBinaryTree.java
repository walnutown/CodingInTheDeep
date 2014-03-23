package amazon;

import lib.TreeNode;

import org.junit.Test;

public class DiameterOfBinaryTree {

   /**
    * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
    * between two leaves in the tree
    * 
    * Simpler version of leetcode/BinaryTreeMaxPathSum
    */
   // refer http://www.geeksforgeeks.org/diameter-of-a-binary-tree/

   /*
    * 3 cases:
    * [1] the diameter path cross the current node
    * [2] the diameter path is in left-subtree
    * [3] the diameter path is in right-subtree
    * time: O(n^2)
    */
   public int getDiameter(TreeNode root) {
      if (root == null)
         return 0;
      int ld = getDiameter(root.left), rd = getDiameter(root.right);
      int d = getHeight(root.left) + getHeight(root.right) + 1;
      return Math.max(Math.max(rd, ld), d);
   }

   private int getHeight(TreeNode node) {
      if (node == null)
         return 0;
      return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
   }

   /*
    * We want to get two return values in each recursive call: diameter and height
    * But Java doen't support pointer, one way to return multiple values is to use global variables.
    * We use a global variable to update the diameter and return height of the subtree in each
    * recursive call
    * time: O(n)
    */
   private int diameter = Integer.MIN_VALUE;

   public int getDiameter1(TreeNode root) {
      if (root == null)
         return 0;
      getHeight1(root);
      return diameter;
   }

   private int getHeight1(TreeNode node) {
      if (node == null)
         return 0;
      int lh = getHeight1(node.left), rh = getHeight1(node.right);
      diameter = Math.max(diameter, lh + rh + 1);
      return Math.max(lh, rh) + 1;
   }

   /*
    * Use array to return multiple values. In Java, array is passed as reference to object
    * time: O(n)
    */
   public int getDiameter2(TreeNode root) {
      return d(root, new int[] { 0 });
   }

   private int d(TreeNode node, int[] height) {
      if (node == null) {
         height[0] = 0;
         return 0;
      }
      int[] lh = { 0 }, rh = { 0 };
      int ld = d(node.left, lh);
      int rd = d(node.right, rh);
      height[0] = Math.max(lh[0], rh[0]) + 1;
      return Math.max(Math.max(ld, rd), lh[0] + rh[0] + 1);
   }

   /*
    * Use a wrapper class to return multiple values
    * time: O(n)
    */
   public int getDiameter3(TreeNode root) {
      return getValue(root).diameter;
   }

   private Value getValue(TreeNode node) {
      Value v = new Value();
      if (node == null)
         return v;
      Value lv = getValue(node.left), rv = getValue(node.right);
      v.height = Math.max(lv.height, rv.height) + 1;
      v.diameter = Math.max(Math.max(lv.diameter, rv.diameter), lv.height + rv.height + 1);
      return v;
   }

   class Value {
      int height;
      int diameter;

      public Value() {
         height = 0;
         diameter = 0;
      }
   }

   // try the test cases in
   // https://www.interviewstreet.com/recruit/test/view/sample/4c30cc1084e03/?randhash=81123
   @Test
   public void test() {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.left.left.left = new TreeNode(5);
      root.left.right.right = new TreeNode(6);
      System.out.println(root.printTree());
      System.out.println(getDiameter(root));
      System.out.println(getDiameter1(root));
      System.out.println(getDiameter2(root));
   }

}
