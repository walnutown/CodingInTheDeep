package ch18_hard;

import java.util.Arrays;
import java.util.Random;

public class ch18_2_ShuffleCards {

   /**
    * Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each
    * of the 52! permutations of the deck has to be equally likely. Assume that you are given a
    * random number generator which is perfect
    */
  
   // This is actually a special case of CTCI-GetRandomSetFromArray (the size of the set is same as the array)
   // A good analogy is to pick n balls from the bag continuously.
   private static Random r = new Random(System.currentTimeMillis());

   // recursion
   // shuffle the first n-1 elements, then the new element n
   // time: O(n)
   public static int[] shuffler1(int[] cards, int index) {
      if (index == 0)
         return cards;
      shuffler1(cards, index - 1);
      int k = rand(0, index);
      int tmp = cards[index];
      cards[index] = cards[k];
      cards[k] = tmp;
      return cards;
   }

   // iteration
   /*
    * How does this work?  Use induction to prove
    * The probability that ith element (including the last one) goes to last position is 1/n,
    * because we randomly pick an element in first iteration.
    * The probability that ith element goes to second last position can be proved to be 1/n by
    * dividing it in two cases.
    * Case 1: i = n-1 (index of last element):
    * The probability of last element going to second last position = (probability that last
    * element doesn't stay at its original position) x (probability that the index picked in
    * previous step is picked again so that the last element is swapped)
    * So the probability = ((n-1)/n) x (1/(n-1)) = 1/n
    * Case 2: 0 < i < n-1 (index of non-last):
    * The probability of ith element going to second last position = (probability that ith element is not
    * picked in previous iteration) x (probability that ith element is picked in this iteration)
    * So the probability = ((n-1)/n) x (1/(n-1)) = 1/n
    */
   // time: O(n); space: O(1)
   public static int[] shuffler2(int[] cards) {
      for (int i = cards.length - 1; i > 0; i--) {
         int k = rand(0, i);
         int tmp = cards[i];
         cards[i] = cards[k];
         cards[k] = tmp;
      }
      return cards;
   }

   // both lower, higher inclusive
   public static int rand(int lower, int higher) {
      return lower + r.nextInt(higher + 1 - lower);
   }
   
   public static void main(String[] args) {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      System.out.println(Arrays.toString(shuffler1(A, A.length - 1)));
      System.out.println(Arrays.toString(shuffler2(A)));
   }


}
