package ch7_math_probability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class ch7_7_GetKthMagicNumber {
   /**
    * Design an algorithm to find the kth number such that the only prime factors are 3, 5 and 7
    */

   // Sol1
   // Suppose we have a list of valid numbers, the next number A[k] is the smallest of the values
   // in A[1...k-1] * 3/5/7. We can call getNext() k times to get the first k numbers
   // time: O(k^2); space: O(1)

   // Sol2
   // generate 3*k numbers first, and then sort and get the first k
   // time: O(3klgk + 3klg3k); space: O(3k)
   public ArrayList<Integer> getKthMagicNumber(int k) {
      if (k < 0)
         return null;
      Set<Integer> res = new HashSet<Integer>();
      ArrayList<Integer> prev = new ArrayList<Integer>();
      prev.add(1);
      int count = 0;
      while (count < 3 * k) { // we need generate 3k numbers here, may cause overflow
         ArrayList<Integer> next = new ArrayList<Integer>();
         for (int num : prev) {
            if (!res.contains(num * 3)) {
               next.add(num * 3);
               res.add(num * 3);
               if (++count >= 3 * k)
                  break;
            }
            if (!res.contains(num * 5)) {
               res.add(num * 5);
               next.add(num * 5);
               if (++count >= 3 * k)
                  break;
            }
            if (!res.contains(num * 7)) {
               res.add(num * 7);
               next.add(num * 7);
               if (++count >= 3 * k)
                  break;
            }
         }
         prev = next;
      }
      PriorityQueue<Integer> qu = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
         public int compare(Integer o1, Integer o2) {
            return o1.intValue() - o2.intValue();
         }
      });
      for (int num : res)
         qu.add(num);
      ArrayList<Integer> r = new ArrayList<Integer>();
      while (--k > 0)
         r.add(qu.poll());
      return r;
   }

   // Maintain 3 queues, when we get A[k], we push A[k]*3, A[k]*5, A[k]*7 into specific queues,
   // depending on the value of A[k]. 
   // eg, if A[k] comes from queue5, we only push A[k]*5 and A[k]*7. We skip A[k]*3 because the value
   // should have been pushed into queue3 before
   // time: O(k); space: O(3k)
   public int getKthMagicNumber2(int k) {
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
            qu3.poll();
            qu3.add(val * 3);
            qu5.add(val * 5);
            qu7.add(val * 7);
         } else if (val == v5) {
            qu5.poll();
            qu5.add(val * 5);
            qu7.add(val * 7);
         } else {
            qu7.poll();
            qu7.add(val * 7);
         }
      }
      return val;
   }

   @Test
   public void test() {
      System.out.println(getKthMagicNumber(15));
      System.out.println(getKthMagicNumber2(10));
   }

}
