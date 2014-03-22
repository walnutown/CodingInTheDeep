package lib;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;

/*
 * Implementation of segment tree
 * Use array to serialize the tree, this helps to reduce the building time of tree to O(n)
 * This is a balanced tree, for each node i in the array, its left child is 2*i+1, right child is
 * 2*i+2, and its
 * parent is (i-1)/2. Node with index 0 is the root of the tree.
 * The array representation of tree is also used in heap implementation
 */
public class TestSegmentTree {

   @Test
   public void testBuildTree() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
      System.out.println("testBuildTree()");
      SegmentTree st = new SegmentTree(A);
      System.out.println(st.toString());
   }

   @Test
   public void testGetSum() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
      SegmentTree st = new SegmentTree(A);
      System.out.println("testGetSum()");
      System.out.println(st.printRange(0, 5));
      System.out.println(st.getSum(0, 5));
   }

   @Test
   public void testUpdateValue() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
      SegmentTree st = new SegmentTree(A);
      System.out.println("testUpdateValue()");
      System.out.println(st.printRange(0, 5));
      System.out.println(st.getSum(0, 5));
      st.updateValue(1, 20);
      System.out.println(st.toString());
      System.out.println(st.printRange(0, 5));
      System.out.println(st.getSum(0, 5));
   }

   public class SegmentTree {
      private int[] ST;
      private int[] A;

      public SegmentTree(int[] A) {
         this.A = Arrays.copyOfRange(A, 0, A.length);
         int treeSize = 2 * A.length - 1;
         ST = new int[treeSize];
         builder(this.A, 0, A.length - 1, 0);
      }

      /**
       * Use recursion to build the tree
       * time: O(n)
       * 
       * @param as, ae are the starting index and ending index of the range in A
       * @param si is the index of the node (representing the segment range) in ST
       */
      private int builder(int[] A, int as, int ae, int si) {
         // If there is one element in array, store it in current node of
         // segment tree and return
         if (as == ae) {
            ST[si] = A[as];
            return A[as];
         }
         int mid = (as + ae) >> 1;
         ST[si] = builder(A, as, mid, si * 2 + 1) + builder(A, mid + 1, ae, si * 2 + 2);
         return ST[si];
      }

      /**
       * Use recursion to get the node value.
       * Combine as/ae, qs/qe to get the terminating condition
       * time: O(lgn)
       * 
       * @param qs, qe are the starting and ending index of the qeruy range
       */
      public int getSum(int qs, int qe) {
         if (qs < 0 || qe > A.length - 1 || qs > qe)
            throw new NoSuchElementException("Invalid range query");
         return getSumHelper(0, 0, A.length - 1, qs, qe); // start from the root
      }

      private int getSumHelper(int si, int as, int ae, int qs, int qe) {
         // If segment of this node is a part of query range, then return the
         // sum of the segment
         if (qs <= as && qe >= ae)
            return ST[si];
         // If segment of this node is out of the query range
         if (ae < qs || as > qe)
            return 0;
         // If a part of this segment overlaps with the query range
         int mid = (as + ae) >> 1;
         return getSumHelper(2 * si + 1, as, mid, qs, qe) + getSumHelper(2 * si + 2, mid + 1, ae, qs, qe);

      }

      /**
       * Update a value in the segment tree with given index
       */
      public void updateValue(int index, int newValue) {
         if (index < 0 || index > A.length)
            throw new NoSuchElementException("Index out of bound");
         // Get the difference between new value and old value
         int diff = newValue - A[index];
         // update the elment array
         A[index] = newValue;
         // update the values of nodes in segment tree
         updateValueHelper(0, 0, A.length - 1, index, diff);
      }

      private void updateValueHelper(int si, int as, int ae, int index, int diff) {
         if (as > ae || index < as || index > ae)
            return;
         ST[si] += diff;
         if (as == ae)
            return;
         int mid = (as + ae) >> 1;
         updateValueHelper(2 * si + 1, as, mid, index, diff);
         updateValueHelper(2 * si + 2, mid + 1, ae, index, diff);
      }

      public String printRange(int qs, int qe) {
         if (qs < 0 || qe > A.length)
            throw new NoSuchElementException("Qeury index is out of range");
         int[] range = Arrays.copyOfRange(A, qs, qe + 1);
         return Arrays.toString(range);
      }

      public String toString() {
         return Arrays.toString(ST);
      }

   }
}
