package google;

import org.junit.Test;

public class FindLocalMinima {
   /*
    * Suppose we are given an array A[1 .. n] with the special property that A[1] ≥ A[2] and
    * A[n − 1] ≤ A[n]. We say that an element A[x] is a local minimum if it is less than or equal
    * to both its neighbors, or more formally, if A[x − 1] ≥ A[x] and A[x] ≤ A[x + 1]. For example,
    * there are five local minima in the following array:
    * 9 7 7 2 1 3 7 5 4 7 3 3 4 8 6 9
    * We can obviously find a local minimum in O(n) time by scanning through the array. Describe
    * and analyze an algorithm that finds a local minimum in O(log n) time.
    */

   // http://www.careercup.com/question?id=8223978
   // Modify binary search
   // Each time, we compare A[mid] with A[mid-1] and A[mid+1]
   // The conditions A[1] ≥ A[2] and A[n − 1] ≤ A[n] ensures that we can get the local minima
   // time: O(lgn); space: O(1)
   public int getLocalMinima(int[] A) throws Exception{
      if (A==null)
         throw new Exception("Invalid input");
      int N = A.length;
      if (N<3)
         throw new Exception("Invalid input");
      int start =0, end = N-1;
      while (start<=end){
         int mid = start + (end-start)/2;
         if (mid-1<0 || mid+1 >=N)
            throw new Exception("Invalid input");
         if (A[mid]<=A[mid-1] && A[mid]<=A[mid+1])
            return A[mid];
         else if (A[mid]>A[mid-1] && A[mid]<=A[mid+1])
            end = mid-1;
         else if (A[mid]<=A[mid-1] && A[mid]>A[mid+1])
            start = mid+1;
         else   // local maxima, randomly pick one half to continue
            start = mid+1;  
      }
      return -1; // no local minima
   }
   
   @Test
   public void test() throws Exception{
      int[] A = new int[]{7,6,3,4,2,9,1,8};
      int[] B = new int[]{7,6,9};
      System.out.println(getLocalMinima(A));
      System.out.println(getLocalMinima(B));
   }
}
