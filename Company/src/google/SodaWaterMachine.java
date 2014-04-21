package google;

import lib.Interval;

import org.junit.Test;

public class SodaWaterMachine {
   /*
    * A soda water machine,press button A can generate 300-310ml, button B can generate 400-420ml
    * and button C can generate 500-515ml, then given a number range [min, max], tell if all the
    * numbers of water in the range can be generated.
    */
   // This question is similar to famous coinChange, we can call it rangeCoinChange

   // Dynamic Programming
   // Maintain a boolean array to check whether a volume can be generated
   // time: O(max * rangeNum * averageRange); space: O(max)
   public boolean canBeGenerated(Interval[] ranges, Interval target) {
      int min = target.start, max = target.end;
      boolean[] dp = new boolean[max + 1];
      dp[0] = true;
      for (int i = 0; i <= max; i++) {
         for (int j = 0; j < ranges.length; j++) {
            Interval range = ranges[j];
            for (int k = range.start; k <= range.end; k++) {
               if (i >= k && dp[i - k])
                  dp[i] = true;
            }
         }
      }
      for (int i = min; i <= max; i++) {
         if (!dp[i])
            return false;
      }
      return true;
   }

   @Test
   public void test() {
      Interval[] ranges = new Interval[] { 
            new Interval(300, 310), 
            new Interval(400, 402),
            new Interval(500, 515) 
      };
      Interval target = new Interval(500,516);
      Interval target2 = new Interval(500,515);
      System.out.println(canBeGenerated(ranges, target));
      System.out.println(canBeGenerated(ranges, target2));
   }
}
