package facebook;

import java.util.ArrayList;

import org.junit.Test;

public class BeautifulNumberGame {
   /*
    * Initially there is a number n written on board. Two players start playing a game turn by turn.
    * Each player has to replace the number n written on the board by n-2^k (for some k >= 0 such
    * that 2^k < n)?
    * Also the number n-2^k has to be as beautiful as n (The beauty of a number depends on the
    * number of one's in its binary representation). The player loses the game when he can't select
    * any such k.
    * Given the initial number n, determine which player will win the game if both players play
    * optimally. n > 0 and n <= 10^9.
    */

   /**
    * Because we have to keep the number of ones, in each round, we're only allowed to swap the
    * position of a 1 with a 0. Besides, according to the rule 'n -> n-2^k', only one kind of swap
    * will meet the requirements. That's when 1 and 0 are neighbors, and 1 is on the left of 0.
    * eg, 10010 -> 10010-1000= 1010, or 10010 -> 10010-1=10001
    * We can see there're two cases of swap:
    * [1]after swap, the number of 0s remain the same. eg, 10010 -> 10001
    * [2]after swap, the number of 0s decrement by 1. eg, 10010 -> 1010
    * The number of 0s represent the number of remaining rounds in the game. For each player, the
    * optimal swap
    * is that after the swap, there're even number of 0s, so that he can do the last swap.
    */
   // refer: http://www.careercup.com/question?id=5399897561890816
   // player 1 create the first N
   // 1 represents p1 wins, -1 represents p2 wins
   public int findWinner(int N) {
      ArrayList<Integer> zeroBuckets = new ArrayList<Integer>();
      int zeroCount = 0;
      while (N > 0) {
         if ((N & 1) == 0)
            zeroCount++;
         else {
            if (zeroCount>0)
               zeroBuckets.add(0, zeroCount);
            zeroCount = 0;
         }
         N >>= 1;
      }
      zeroBuckets.add(0, 0);
      return finder(zeroBuckets, -1);
   }

   private int finder(ArrayList<Integer> A, int player) {
      if (A.size() == 1)
         return 0 - player;
      int sum = 0;
      for (int i = 1; i < A.size(); i++)
         sum += A.get(i);
      if (A.size() == 2)
         return sum % 2 == 0 ? 0 - player : player;
      // if there're more than 2 zero buckets, we have two choices
      if (sum % 2 != 0) { // number of remaining 0s is odd, keep the number
         swapWithoutDecrement(A);
      } else {
         if (A.get(1) > 0)
            swapWithDecrement(A);
         else
            swapWithoutDecrement(A);
      }
      return finder(A, 0 - player);
   }

   private void swapWithoutDecrement(ArrayList<Integer> A) {
      int lastIndex = A.size() - 1, lastValue = A.get(lastIndex);
      A.set(lastIndex, lastValue - 1);
      A.set(lastIndex - 1, A.get(lastIndex - 1) + 1);
      if (A.get(lastIndex) == 0)
         A.remove(lastIndex);
   }

   private void swapWithDecrement(ArrayList<Integer> A) {
      A.set(1, A.get(1) - 1);
      A.set(0, A.get(0) + 1);
   }

   @Test
   public void test() {
      for (int i = 1; i < 100; i++) {
         System.out.println(Integer.toBinaryString(i) + ": " + findWinner(i));
      }
   }
}
