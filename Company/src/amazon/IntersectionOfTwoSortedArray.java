package amazon;

import java.util.ArrayList;

import org.junit.Test;

public class IntersectionOfTwoSortedArray {

   /**
    * Find the intersection of two sorted arrays.
    * Intersection here means the same element
    * eg, A = [1,2,3,4], B = [3, 4, 5, 6]
    * intersections = [3, 4]
    */
   
   // http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
   
   // Sol1
   // The naive solution is to traverse array A, O(n).
   // for each element in the array, check if it's in array B, O(m)
   // time: O(m*n); space: O(1)
   
   
   // Sol2
   // One optimization is to use a set for array B to reduce checking time from O(m) to O(1),
   // yet, it takes O(m) time and O(m) space to build the set. And this solution actually doesn't
   // use the given condition "sorted array"
   // time: O(n+m); space: O(m)
   
   // Sol3
   // Another optimization is to binary search array B to do the checking
   // This solution is good when A is small compared to B. The special case is that n=1, m=1 billion
   // time: O(n*lgm); space: O(1)
   
   // Sol4
   // If B is very large, say 1 billion and is not able to store on the RAM.
   // We can use map-reduce to store B in different machines and each machine maps to a range of numbers
   // When we want to search a number, we first locates the machine of the range and then binary search
   // the values in the machine
   // time: O(n*lg(m/k)); sapce: O(1)
   
   // Choose sol3 or sol5 according to size of two arrays
   
   // Sol5
   // Maintain two pointers to traverse two arrays
   // If two values are the same, add it into result set and move both pointers
   // Otherwise, move forward the pointer with smaller value
   // time: O(m+n); space: O(1)
   public ArrayList<Integer> getIntersection(int[] A, int[] B) {
      if (A == null || B == null)
         return null;
      ArrayList<Integer> res = new ArrayList<Integer>();
      int m = A.length, n = B.length;
      int i = 0, j = 0;
      while (i < m && j < n) {
         if (A[i] == B[j]) {
            res.add(A[i]);
            i++;
            j++;
         } else if (A[i] < B[j])
            i++;
         else
            j++;
      }
      return res;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3, 4 };
      int[] B = new int[] { 3, 4, 5, 6 };
      System.out.println(getIntersection(A, B));
   }

}
