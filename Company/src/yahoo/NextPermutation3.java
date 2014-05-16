package yahoo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class NextPermutation3 {

   /**
    * There is a sequence of increasing numbers that have the same number of
    * binary 1s in them. Given n, the number of 1 bits set in each number, find the nÕth number in
    * the series
    */

   // Basically is a BFS
   // [1] initialize the string as k 1s
   // [2] number in each level has the same number of zeros, search until n-th number
   // [3] Note that we need to mark visited numbers here to avoid duplicates
   public String getNext(int k, int n) {
      // assume n is smaller than the length of the number series
      StringBuilder sb = new StringBuilder();
      while (k-- > 0)
         sb.append(1);
      Queue<String> qu = new LinkedList<String>();
      qu.add(sb.toString());
      Set<String> visited = new HashSet<String>();
      while (!qu.isEmpty()) {
         String curr = qu.poll();
         System.out.println(curr);
         n--;
         if (n == 0)
            return curr;
         for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == '1') {
               String next = curr.substring(0, i + 1) + "0" + curr.substring(i + 1);
               if (visited.contains(next))
                  continue;
               qu.add(next);
               visited.add(next);
            }
         }
      }
      return "";
   }

   @Test
   public void test() {
      int k = 5, n = 30;
      System.out.println(getNext(k, n));
   }

}
