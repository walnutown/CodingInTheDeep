package ch4_trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ch4_8_IsSubTree {

   /*
    * Two very large binary trees: T1 and T2, 
    * create an algorithm to decide if T2 is a subtree of T1
    */
   public static void main(String[] args) {
      int[] arr1 = new int[]{50,3,5,7, 9, 14, 23, 32};
      int[] arr2 = new int[]{50,3,5};
      TreeNode t1 = new TreeNode(arr1);
      TreeNode t2 = new TreeNode(arr2);
      System.out.println(isSubtree(t1, t2));
   }
  
   public static boolean isSubtree(TreeNode t1, TreeNode t2){
      if (t1 == null || t2 == null)
         return t1 == null && t2 == null;
      Queue<TreeNode> qu = new LinkedList<TreeNode>();
      qu.add(t1);
      while (!qu.isEmpty()){
         TreeNode curr = qu.poll();
         if (isSameTree(curr, t2))
            return true;
         if (curr.left != null)
            qu.add(curr.left);
         if (curr.right != null)
            qu.add(curr.right);
      }
      return false;
   }
   
   public static boolean isSameTree(TreeNode t1, TreeNode t2){
      if (t1 == null || t2 == null)
         return t1 == null && t2 == null;
      return (t1.val == t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
   }
   
   // fits the small case
   // create a string representing the in-order and pre-order traversal. If T1's pre-order traversal is a substring
   // of T1' pre-order traversal, and T2's in-order traversal is a substring of T1's in-order traversal, then T2 is 
   // a subtree of T1
   // NOTE: null node should be represented by a special character to indicate the relative position
   
//   public static boolean isSubtree2(TreeNode t1, TreeNode t2){
//      
//   }
   
   

}
