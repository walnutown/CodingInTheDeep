package facebook;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class WeightedIntervalScheduling {
   /*
    * Given a set of n jobs with [start time, end time, cost] find a subset so that no 2 jobs
    * overlap and the cost is maximum.
    */
   
   // [1] Sort all the jobs according to their start and end time, O(nlgn)
   // [2] Build a table to store the closest compatible previous job, O(n^2)
   // [3] Dynamic Programming to find the max weight, O(n)
   public class Interval{
      int start;
      int end;
      int cost;
      Interval(int start, int end, int cost){
         this.start = start;
         this.end = end;
         this.cost = cost;
      }
   }
   
   public int getMaxWeight(Interval[] intervals){
      Arrays.sort(intervals, new Comparator<Interval>(){
         public int compare(Interval int1, Interval int2){
            if (int1.start == int2.start)
               return int1.end-int2.end;
            return int1.start - int2.start;
         }
      });
      int N = intervals.length;
      int[] P = buildOptimalTable(intervals);
      int[] dp = new int[N+1];
      dp[1] = intervals[0].cost;
      for (int i=2; i<=N; i++){
         dp[i] = Math.max(dp[P[i]]+ intervals[i-1].cost, dp[i-1]);
      }
      return dp[N];
   }
   
   // If there's no previous compatible job, store 0 
   private int[] buildOptimalTable(Interval[] intervals){
      int[] P = new int[intervals.length+1];
      for (int i=2; i<=intervals.length; i++){
         for (int j=i-1; j>=1; j--){
            if (intervals[j-1].end < intervals[i-1].start){
               P[i] = j;
               break;
            }
         }
      }
      return P;
   }
   
   @Test
   public void test(){
      Interval[] intervals = new Interval[]{
            new Interval(1,3, 15),
            new Interval(2,5, 10),
            new Interval(4,7, 4),
            new Interval(6,9,10),
      };
      System.out.println(getMaxWeight(intervals));
   }
}
