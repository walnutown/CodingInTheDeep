package groupon;

import lib.TreeNode;

public class MedianOfStreamingData {

   /**
    * Given a data stream, find the median of the data using online algorithm
    * 
    * Note:
    * There're no duplicates in the stream
    */
   public static void main(String[] args) {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      getMedian(A);
   }

   /*
    * Use a binary search tree to store the data, and a variable to store the median node
    * Every time, when a new data is inputed, insert the data into the BST, and then adjust the
    * median node according to the new node's value
    * <1> insert O(lgn)
    * <2> adjust O(lgn) -- find previous node or next node
    * <3> get median -- O(1)
    */
   static int medianIndex = 0;

   public static void getMedian(int[] nums) {
      TreeNode root = null;
      TreeNode median = null;

      int size = 0;
      for (int num : nums) {
         root = insertNode(root, num);
         if (size == 0)
            median = root;
         else
            median = adjustMedian(root, median, num, size);
         size++;
      }
   }

   public static TreeNode insertNode(TreeNode root, int num) {
      if (root == null)
         return new TreeNode(num);
      if (root.val > num)
         root.left = insertNode(root.left, num);
      else if (root.val < num)
         root.right = insertNode(root.right, num);
      return root;
   }

   public static TreeNode adjustMedian(TreeNode root, TreeNode median, int num, int size) {
//      int oldMedian = median.val;
//      if (oldMedian < num && medianIndex != size / 2) {
//         median = getSuccessor(root, median);
//         medianIndex++;
//      } else if (oldMedian > num && medianIndex == size / 2)
//         median = getPredecessor(root, median);
//      if (size % 2 == 0)
//         System.out.println(median);
//      else
//         System.out.println((double) (median.val + oldMedian) / 2.0);
//      return median;
   }

   public static TreeNode getPredecessor(TreeNode root, TreeNode curr) {
      if (curr.left != null) {
         TreeNode p = curr.left;
         while (p.right != null)
            p = p.right;
         return p;
      } else {
         TreeNode p = curr.parent, pp = curr;
         while (p != null) {
            if (p.right.equals(pp))
               return p;
            p = p.parent;
            pp = pp.parent;
         }
         return null;
      }
   }

   public static TreeNode getSuccessor(TreeNode root, TreeNode curr) {
      if (curr.right != null) {
         TreeNode p = curr.right;
         while (p.left != null)
            p = p.left;
         return p;
      } else {
         TreeNode p = curr.parent, pp = curr;
         while (p != null) {
            if (p.left.equals(pp))
               return p;
            p = p.parent;
            pp = pp.parent;
         }
         return null;
      }
   }

}
