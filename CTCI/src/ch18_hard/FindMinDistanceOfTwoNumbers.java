package ch18_hard;

import org.junit.Test;

public class FindMinDistanceOfTwoNumbers {
   /**
    * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and
    * y in arr[]. The array might also contain duplicates. You may assume that both x and y are
    * different and present in arr[].
    * Examples:
    * Input: arr[] = {1, 2}, x = 1, y = 2
    * Output: Minimum distance between 1 and 2 is 1.
    * Input: arr[] = {3, 4, 5}, x = 3, y = 5
    * Output: Minimum distance between 3 and 5 is 2.
    * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
    * Output: Minimum distance between 3 and 6 is 4.
    * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
    * Output: Minimum distance between 3 and 2 is 1.
    * 
    */
   
   // http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
   
   // Sol1
   // The naive solution is to use two loops
   // One to locate x or y, another to find the min distance from another numebr to it.
   // time: O(n^2); space: O(1)

   // Sol2
   // Create a wrapper class to hold the index and value of last occurrence of x or y.
   // Traverse the array, once we find a x or y, update the min distance if current occurrence is
   // different from the previous occurrence
   // time: O(n); space: O(1)
   public int getMinDistance(int[] A, int x, int y) throws Exception {
      if (A == null || A.length == 0)
         throw new Exception("Invalid input");
      int i = 0, N = A.length, min = Integer.MAX_VALUE;
      Occurrence prev = null;
      while (i<N){
        while (i<N && A[i]!=x && A[i]!=y)   i++;
        if (i==N)   return min;
        Occurrence curr = new Occurrence(i, A[i]);
        if (prev!=null && prev.value != curr.value){
           min = Math.min(min, curr.index-prev.index);
        }
        prev = curr;
        i++;
      }
      return min;
   }
   
   private class Occurrence{
      int index;
      int value;
      public Occurrence(int index, int value){
         this.index = index;
         this.value = value;
      }
   }
   
   @Test
   public void test() throws Exception{
      int[] A = new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
      int x = 3, y = 6;
      System.out.println(getMinDistance(A, x, y));
   }
}
