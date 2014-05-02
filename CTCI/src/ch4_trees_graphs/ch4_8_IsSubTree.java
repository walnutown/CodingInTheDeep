package ch4_trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class ch4_8_IsSubTree {

   /**
    * Two very large binary trees: T1 and T2,
    * create an algorithm to decide if T2 is a subtree of T1
    */

   // BFS to find the node same to T2's root, then check if the two trees are same
   // time: O(n^2)
   public boolean isSubtree(TreeNode t1, TreeNode t2) {
      if (t1 == null || t2 == null)
         return t1 == null && t2 == null;
      Queue<TreeNode> qu = new LinkedList<TreeNode>();
      qu.add(t1);
      while (!qu.isEmpty()) {
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

   private boolean isSameTree(TreeNode t1, TreeNode t2) {
      if (t1 == null || t2 == null)
         return t1 == null && t2 == null;
      return (t1.val == t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
   }

   @Test
   public void test() {
      int[] arr1 = new int[] { 50, 3, 5, 7, 9, 14, 23, 32 };
      int[] arr2 = new int[] { 50, 3, 5 };
      TreeNode t1 = new TreeNode(arr1);
      TreeNode t2 = new TreeNode(arr2);
      System.out.println(isSubtree(t1, t2));
   }

}
