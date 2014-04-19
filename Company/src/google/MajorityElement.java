package google;

import org.junit.Test;

public class MajorityElement {
   /*
    * A majority element in an array of size n is an element that appears more than n/2 times
    * (and hence there is at most one such element).
    * Given an array of non-negative integers, find the majority element, if not exist, return -1
    */

   // http://www.geeksforgeeks.org/majority-element/
   
   // Sol1
   // Sort and count
   // time: O(nlgn); space: O(1)
   
   // Sol2
   // Median is the majority element if there exists one
   // Quick select to find the median element and check
   // time: O(k*n); space: O(1)
   
   // Sol3
   // Use a map to count the occurrence of each element
   // time: O(n); space: O(n)
   
   // Sol4
   // Moore's voting algorithm
   // Basic idea is to find a candidate through counting and then check
   // If the current element is different from the candidate, decrement the count
   // If the current element is same to the candiadte, increment the count
   // The count of majority element is always positive after the traversal of whole array
   // time: O(n); space: O(1)
   public int getMajority(int[] A){
      int candidate = -1, N = A.length, count = 0;
      for (int num : A){
         if (count ==0)
            candidate = num;
         if (num==candidate)
            count++;
         else
            count--;
      }
      count = 0;
      for (int num : A){
         if (num==candidate)
            count++;
      }
      return count > N/2 ? candidate:-1;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1, 1, 1, 1, 1, 2, 3, 4};
      System.out.println(getMajority(A));
   }
}
