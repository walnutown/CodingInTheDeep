package ch7_math_probability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ch7_7_GetKthMagicNumber {
   /**
    * Design an algorithm to find the kth number such that the only prime factors are 3, 5 and 7
    */
   public static void main(String[] args) {
      System.out.println(getKthMagicNumber(15));
      System.out.println(getKthMagicNumber2(5));
   }
   
   // time: O(3klgk + 3klg3k); space: O(3k)
   public static ArrayList<Integer> getKthMagicNumber(int k) {
      if (k < 0)
         return null;
      Set<Integer> res = new HashSet<Integer>();
      ArrayList<Integer> prev = new ArrayList<Integer>();
      ArrayList<Integer> next = new ArrayList<Integer>();
      prev.add(1);
      int count = 0;
      while (count < 3*k) { // we need generate 3k numbers here, may cause overflow
         for (int num : prev) {
            if (!res.contains(num * 3)) {
               next.add(num * 3);
               res.add(num * 3);
               if (++count >= 3*k)
                  break;
            }
            if (!res.contains(num * 5)) {
               res.add(num * 5);
               next.add(num * 5);
               if (++count >= 3*k)
                  break;
            }
            if (!res.contains(num * 7)) {
               res.add(num * 7);
               next.add(num * 7);
               if (++count >= 3*k)
                  break;
            }
         }
         prev = new ArrayList<Integer>(next);
         next.clear();
      }
      PriorityQueue<Integer> qu = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
         public int compare(Integer o1, Integer o2) {
            return o1.intValue() - o2.intValue();
         }
      });
      for (int num : res)
         qu.add(num);
      ArrayList<Integer> r = new ArrayList<Integer>();
      while (--k>0)
         r.add(qu.poll());
      return r;
   }
   
   // time: O(k); space: O(3k)
   public static int getKthMagicNumber2(int k) {
      if (k < 0)
         return 0;
      int val = 0;
      Queue<Integer> qu3 = new LinkedList<Integer>();
      Queue<Integer> qu5 = new LinkedList<Integer>();
      Queue<Integer> qu7 = new LinkedList<Integer>();
      qu3.add(1);
      for (int i = 0; i <= k; i++) {
         int v3 = qu3.isEmpty() ? Integer.MAX_VALUE : qu3.peek();
         int v5 = qu5.isEmpty() ? Integer.MAX_VALUE : qu5.peek();
         int v7 = qu7.isEmpty() ? Integer.MAX_VALUE : qu7.peek();
         val = Math.min(Math.min(v3, v5), v7);
         if (val == v3) {
            qu3.remove();
            qu3.add(val * 3);
            qu3.add(val * 5);
            qu3.add(val * 7);
         } else if (val == 5) {
            qu5.remove();
            qu5.add(val * 5);
            qu5.add(val * 7);
         } else {
            qu5.remove();
            qu5.add(val * 7);
         }
      }
      return val;
   }
}
