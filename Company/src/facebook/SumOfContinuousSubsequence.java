package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SumOfContinuousSubsequence {
   /*
    * Given an array, write a function to print all continuous subsequences in the array which sum of
    * 0.
    * e.g:
    * Input:
    * Array = [-1, -3, 4, 5, 4]
    * output:
    * -1, -3, 4
    */

   // Naive solution is to form all the continuous subsequences, and sum all its values to check whether it's 0
   // time: O(n^3); space:O(n^3)

   // Dynamic Programming
   // Note that in the naive solution, there're lots of duplicate calculations in the sum step,
   // we can reduce those duplicate calculations using DP.
   // Get the sum of all subsequences using DP, then find sum of 0 subsequences
   // time: O(n^2); space: O(n^2)
   public ArrayList<int[]> getSubsequence(int[] A) {
      ArrayList<int[]> res = new ArrayList<int[]>();
      if (A == null || A.length == 0)
         return res;
      int N = A.length;
      int[][] dp = new int[N][N];
      for (int i = 0; i < N; i++) {
         dp[i][i] = A[i];
      }
      for (int i = 0; i < N; i++) {
         for (int j = i + 1; j < N; j++) {
            dp[i][j] = dp[i][j - 1] + A[j];
         }
      }
      for (int i = 0; i < N; i++) {
         for (int j = i; j < N; j++) {
            if (dp[i][j] == 0)
               res.add(Arrays.copyOfRange(A, i, j + 1));
         }
      }
      return res;
   }

   // Build an array S, S[i] = Sum(A[0...i])
   // There're two cases indicating a subsequence of sum 0:
   // [1] S[i] == 0, [0,i] is a subsequence of sum 0
   // [2] S[i] == S[j], [i+1,j] is a subsequence of sum 0
   // We can use a map to store sum value and list of indices.
   // Besides, add (0, -1) initially to make things easier
   // time: average case < O(n^2), worst case O(n^2); space: O(n)
   public ArrayList<int[]> getSubsequence2(int[] A) {
      ArrayList<int[]> res = new ArrayList<int[]>();
      if (A == null || A.length == 0)
         return res;
      int sum = 0, N = A.length;
      Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(-1);
      map.put(0, list);
      for (int i = 0; i < N; i++) {
         sum += A[i];
         if (!map.containsKey(sum)) {
            ArrayList<Integer> indices = new ArrayList<Integer>();
            map.put(sum, indices);
         }
         map.get(sum).add(i);
      }
      for (ArrayList<Integer> indices : map.values()) {
         if (indices.size() == 1)
            continue;
         for (int i = 0; i < indices.size(); i++) {
            for (int j = i + 1; j < indices.size(); j++) {
               res.add(Arrays.copyOfRange(A, indices.get(i)+1, indices.get(j)+1));
            }
         }
      }
      return res;
   }

   @Test
   public void test() {
      int[] A = new int[] { -1, -3, 4, 5, 4 , 0};
      for (int[] nums : getSubsequence(A))
         System.out.println(Arrays.toString(nums));
      for (int[] nums : getSubsequence2(A))
         System.out.println(Arrays.toString(nums));
   }
}
