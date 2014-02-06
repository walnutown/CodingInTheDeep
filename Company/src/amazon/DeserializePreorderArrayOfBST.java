package amazon;

import lib.TreeNode;

public class DeserializePreorderArrayOfBST {
   
   /**
    * A BST has been serizliazed as an array, using pre-order traversal.
    * Now recover the BST from the array
    * 
    * Sol1: time O(n), same as preorder traversal
    *   <1> do preorder traversal, insert the node to position where min<node.val<max
    * Sol2: time O(n), sort to get the inorder array first 
    *   <1> refer to Leetcode -- constructBinaryTreeFromInorderAndPreorderTraversal
    */
   public static void main(String[] args) {
      System.out.println(deserializatoinOfBST1(new int[]{30, 20, 10, 40, 35, 50}).printTree());
   }
   
   private static int index = 0;
   public static TreeNode deserializatoinOfBST1(int[] A){
      if (A==null || A.length==0)   return null;
      return recover(Integer.MIN_VALUE, Integer.MAX_VALUE, A);
   }
   public static TreeNode recover(int min, int max, int[] A){
      TreeNode node = null;
      int val = A[index];
      if (val>min && val<max){
         node = new TreeNode(val);
         if (++index < A.length){
            node.left = recover(min, val, A);
            node.right = recover(val, max, A);
         }
      }
      return node;
   }
}
