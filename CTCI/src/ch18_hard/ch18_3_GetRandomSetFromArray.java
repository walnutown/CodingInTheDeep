package ch18_hard;

import java.util.Arrays;
import java.util.Random;

public class ch18_3_GetRandomSetFromArray {

   /**
    * Write a method to randomly generate a set of m integers from an array of size n. Each element
    * must have equal probability of being chosen
    */
   public static void main(String[] args) {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      System.out.println(Arrays.toString(getRandomSet1(A, 4, A.length - 1)));
      System.out.println(Arrays.toString(getRandomSet2(A, 4)));
   }

   private static Random r = new Random(System.currentTimeMillis());

   // recursion
   public static int[] getRandomSet1(int[] A, int m, int i) {
      if (i == m - 1)
         return Arrays.copyOfRange(A, 0, m);
      if (i > m - 1) {
         int[] set = getRandomSet1(A, m, i - 1);
         int k = rand(0, i);
         if (k < m)
            set[k] = A[i];
         return set;
      }
      return null;
   }

   // iteration
   // proof : use deduction
   // probability we need: m/n
   // case1: if the element is in the left part, p = p(stay in set)
   // m/(m+1) * (m+1)/(m+2)...(n-1)/n = m/n
   // case2: if the element is in the right part, p = p(be chosen) * p(stay in set)
   // m/(m+1) * (m+1)/(m+2)...(n-1)/n = m/n
   public static int[] getRandomSet2(int[] A, int m) {
      int[] set = Arrays.copyOfRange(A, 0, m);
      for (int i = m; i < A.length; i++) {
         int k = rand(0, i);
         if (k < m)
            set[k] = A[i];
      }
      return set;
   }

   // both lower, higher inclusive
   public static int rand(int lower, int higher) {
      return lower + r.nextInt(higher + 1 - lower);
   }

}
