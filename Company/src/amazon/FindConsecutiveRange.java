package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindConsecutiveRange {

   /**
    * Given an array of integers, output all the interval ranges
    * e.g. Input: (4，6，5，7，9，10)
    * Output: [4,7][9,10]
    */
   // similar to Leetcode -- LongestConsecutiveSequence
   public static void main(String[] args) {
      System.out.println(findConsecutiveRange(new int[]{4,11, 13, 12, 6,5,7,9,10}).toString());
      
   }
   public static ArrayList<ArrayList<Integer>> findConsecutiveRange(int[] arr){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (arr==null || arr.length==0)   return res;
      Set<Integer> set = new HashSet<Integer>();
      for (int num : arr)   set.add(num);
      while (!set.isEmpty()){
         int mid = set.iterator().next();
         set.remove(mid);
         int start=mid, end=mid;
         while (!set.isEmpty() && set.contains(start-1))    set.remove(--start);
         while (!set.isEmpty() && set.contains(end+1))    set.remove(++end);
         if (end-start+1 >= 2){
            ArrayList<Integer> range = new ArrayList<Integer>();
            range.add(start);   range.add(end);
            res.add(range);
         }
      }
      return res;
   }
}
