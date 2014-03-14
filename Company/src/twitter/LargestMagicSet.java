package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LargestMagicSet {
   /*
    * A zero-indexed array A consisting of N different integers is given. The array contains all
    * integers in the range [0..N−1]. Sets S[K] for 0 ≤ K < N are defined as follows: S[K] = { A[K],
    * A[A[K]], A[A[A[K]]], ... }. Sets S[K] are finite for each K.
    * Write a function:
    * class Solution { public int solution(int[] A); }
    * that, given an array A consisting of N integers, returns the size of the largest set S[K] for
    * this array. The function should return 0 if the array is empty.
    */

   // SOL: return the size of largest set. this sol modifies the original array
   // Note the conditions: <1> N different integers; <2> in the range of [0...N-1]
   // then elements in set can form a circular list. e.g. [1,2,3,5,4,0] has two sets [1,2,3,5,0]
   // (1->2->3->5->0->1...) and [4] (4->4)
   // time: O(n);  space: O(1)
   public int generateLargestMagicSet(int[] A) {
      if (A==null || A.length==0)
         return 0;
      int max = 0;
      for (int i=0; i<A.length; i++){
         int count = 0, currIndex = i, nextIndex = 0;
         while (A[currIndex]>=0){
            count++;
            nextIndex = A[currIndex];
            A[currIndex] = -1;
            currIndex = nextIndex;
         }
         max = Math.max(max, count);
      }
      return max;
   }

   // SOL: return the largest set
   // Note: duplicates, elements may be out of range [0,1...N-1]
   // time: O(n^2); space: O(n)
   public Set<Integer> generateLargestMagicSet2(int[] nums) {
      ArrayList<Set<Integer>> sets = new ArrayList<Set<Integer>>();
      for (int i = 0; i < nums.length; i++)
         sets.add(getSet(i, nums));
      Set<Integer> max = new HashSet<Integer>();
      for (Set<Integer> s : sets) {
         if (s.size() > max.size())
            max = s;
      }
      return max;
   }

   public Set<Integer> getSet(int i, int[] nums) {
      Set<Integer> set = new HashSet<Integer>();
      set.add(nums[i]);
      int curr = nums[i];
      while (curr >= 0 && curr < nums.length && !set.contains(nums[curr])) {
         curr = nums[curr];
         set.add(curr);
      }
      return set;
   }

   @Test
   public void testMaxSet() {
      // int[] nums = new int[] { 2,1,0,2,5,3}; // [2,0,5,3]

      int[] nums = new int[] { 1,2,3,5,4,0 }; 
      System.out.println(generateLargestMagicSet(nums));
      int[] A = new int[] { 2, 1, 0, 2, 2, 0 };  // [2,0]
      System.out.println(generateLargestMagicSet2(A));

   }
}
