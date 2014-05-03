package ch17_moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ch17_5_MasterMind {

   /**
    * The Game of Master Mind is played as follows:
    * The computer has four slots, and each slot will contain a ball that is red(R), yellow(Y),
    * green(G) or blue(B). For example, the computer might have RGGB.
    * You, the user, are trying to guess the solution. You might, for example, guess YRGB.
    * When you guess the correct color for the correct slot, you get a "hit". If you guess a color
    * that exists but is in the wrong slot, you get a "pseudo-hit". Note that a slot that
    * is a hit can never count as a pseudo-hit. For example, if the actual solution is RGBY and you
    * guess GGRR, you have one hit and one pseudo-hit. Write a method that, give a guess and a
    * solution, return the number of hits and pseudo-hits.
    */

   // <1> traverse solution and count hit, as well as the frequency of not matched characters
   // <2> traverse guess and count the pseudoHit
   // time: O(n); space: O(n)
   public int[] solveMasterMind(char[] solution, char[] guess) {
      int hit = 0, pseudoHit = 0;
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < solution.length; i++) {
         char color = solution[i];
         if (guess[i] == color)
            hit++;
         else {
            if (!map.containsKey(color))
               map.put(color, 0);
            map.put(color, map.get(color) + 1);
         }
      }

      for (int i = 0; i < guess.length; i++) {
         char color = guess[i];
         if (solution[i] != color && map.containsKey(color) && map.get(color) > 0) {
            pseudoHit++;
            map.put(color, map.get(color) - 1);
         }
      }
      return new int[] { hit, pseudoHit };
   }

   @Test
   public void test() {
      char[] solution = new char[] { 'G', 'G', 'Y', 'B' };
      char[] guess = new char[] { 'G', 'B', 'Y', 'B' };
      System.out.println(Arrays.toString(solveMasterMind(solution, guess)));
   }
}
