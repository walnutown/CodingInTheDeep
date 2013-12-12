package ch4_trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ch4_8 {

   /*
    * Two very large binary trees: T1 and T2, 
    * create an algorithm to decide if T2 is a subtree of T1
    */
   public static void main(String[] args) {
      int[] arr1 = new int[]{50,3,5,7, 9, 14, 23, 32};
      int[] arr2 = new int[]{50,3,5};
      TreeNode t1 = buildTree(arr1, 0, arr1.length-1);
      TreeNode t2 = buildTree(arr2, 0, arr2.length-1);
      System.out.println(isSubtree(t1, t2));
   }
   
   public static TreeNode buildTree(int[] arr, int start, int end){
      if (start > end)
         return null;
      int mid = (start + end) >> 1;
      TreeNode root = new TreeNode(arr[mid]);
      root.left = buildTree(arr, start, mid-1);
      root.right = buildTree(arr, mid+1, end);
      return root;
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
   
   

}
