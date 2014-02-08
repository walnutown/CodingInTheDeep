package amazon;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArray {

   /**
    * Find the intersection of two sorted arrays
    * intersection here means the same element
    */
   public static void main(String[] args) {
      System.out.println(getIntersection(new int[]{1, 2,3,4}, new int[]{3,4,5,6}));
   }
   
   // time: O(m+n); space: O(m+n)
   public static ArrayList<Integer> getIntersection(int[] A, int[] B){
      if (A==null || B==null)   return null;
      ArrayList<Integer> res = new ArrayList<Integer>();
      int m = A.length, n = B.length;
      int i=0, j=0;
      while (i<m && j<n){
         if (A[i] == B[j]){
            res.add(A[i]);
            i++;j++;
         }else if (A[i] < B[j]) i++;
         else j++;
      }
      return res;
   }

}
