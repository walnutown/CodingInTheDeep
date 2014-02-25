package google;

import java.util.Stack;

import lib.TreeNode;

public class KthElementInBST {

   /**
    * Find the kth element (in order) in a binary search tree
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(new int[]{4,8,10,12,14,20,22}, new int[]{20,8,4,12,10,14,22});
      System.out.println(root.printTree());
      System.out.println(findKthElementInBST(root, 5));
   }
   // iterative in-order traversal, and use a variable to count the order
   public static int findKthElementInBST(TreeNode root, int k){
      if (root==null)   return Integer.MIN_VALUE;
      Stack<TreeNode> st = new Stack<TreeNode>();
      TreeNode curr = root;
      while (curr!=null){
         st.push(curr);
         curr = curr.left;
      }
      int count =0;
      while (!st.isEmpty()){
         curr = st.pop();
         count++;
         if (count==k)  return curr.val;
         curr = curr.right;
         while (curr!=null){
            st.push(curr);
            curr = curr.left;
         }
      }
      return Integer.MIN_VALUE;
   }

}
