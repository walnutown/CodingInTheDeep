package google;

import java.util.ArrayList;

import org.junit.Test;

public class BitCombinations {
   // Given a string, which includes 3 characters: '1', '0', '?'.
   // '?' can be replaced by '1' or '0'.
   // Print all the combinations.

   // Build the string based on previous results
   // time: O(2^n); space: lots of space to store temporary results
   public ArrayList<String> getBitCombinations(String s) {
      ArrayList<String> res = new ArrayList<String>();
      if (s == null || s.length() == 0)
         return res;
      res.add("");
      for (int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         int size = res.size();
         for (int j = size-1; j >= 0; j--) {
            String prev = res.get(j);
            if (ch == '1' || ch == '0')
               res.add(prev + ch);
            else {
               res.add(prev + "1");
               res.add(prev + "0");
            }
         }
         for (int j=0; j<size; j++)
            res.remove(0);
      }
      return res;
   }

   // Backtracking
   // time: O(2^n); space: recursive stack
   public ArrayList<String> getBitCombinations2(String s) {
      ArrayList<String> res = new ArrayList<String>();
      char[] ss = s.toCharArray();
      dfs(ss, 0, res);
      return res;
   }

   private void dfs(char[] ss, int dep, ArrayList<String> res) {
      while (dep < ss.length && ss[dep] != '?')
         // expedite the traversal
         dep++;
      if (dep == ss.length) {
         res.add(new String(ss));
         return;
      }
      ss[dep] = '1';
      dfs(ss, dep + 1, res);
      ss[dep] = '0';
      dfs(ss, dep + 1, res);
      ss[dep] = '?';
   }

   @Test
   public void test() {
      String a = "100???10", b = "?", c = "?01?";
      System.out.println(a + " " + getBitCombinations(a).toString());
      System.out.println(a + " " + getBitCombinations2(a).toString());
      System.out.println(b + " " + getBitCombinations(b).toString());
      System.out.println(b + " " + getBitCombinations2(b).toString());
      System.out.println(c + " " + getBitCombinations(c).toString());
      System.out.println(c + " " + getBitCombinations2(c).toString());
   }
}
