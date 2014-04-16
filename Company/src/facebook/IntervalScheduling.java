package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import lib.Interval;

import org.junit.Test;

public class IntervalScheduling {

   /*
    * Given a set of intervals, find the largest subset of intervals that no two intervals overlap
    * with each other
    */

   // Greedy
   // Sort the intervals according to their end time
   // Each time, we select the compatible interval that ends first
   // Proof: If the result subset is not the optimal one, there will be contradiction
   // time: O(nlgn); space: O(1)
   public ArrayList<Interval> findMaximumSubset(Interval[] intervals) {
      Arrays.sort(intervals, new Comparator<Interval>() {
         public int compare(Interval int1, Interval int2) {
            return int1.end - int2.end;
         }
      });
      ArrayList<Interval> res = new ArrayList<Interval>();
      res.add(intervals[0]);
      int i = 0;
      while (i<intervals.length){
         int j = i+1;
         while (j<intervals.length && intervals[i].end>intervals[j].start)
            j++;
         if (j<intervals.length)
            res.add(intervals[j]);
         i = j;
      }
      return res;
   }
   
   @Test
   public void test(){
      Interval[] intervals = new Interval[]{
            new Interval(1,3, 15),
            new Interval(2,5, 10),
            new Interval(2,7, 4),
            new Interval(6,9,10),
      };
      System.out.println(findMaximumSubset(intervals));
   }
}
