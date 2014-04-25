package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StringPermutations2 {
   /*
    * Given an array of characters and an array of the number of occurrences.
    * Find all the strings of size k that can be built using given characters.
    * eg, 
    * input: A = [a,b,c], B = [2,1,3], k = 2
    * output: aa, ab, ac, ba, bc, ca, cb, cc
    * 
    */
   
   // We can convert this problem to Leetcode/Permutations2 
   // The difference lies in that we have another termination condition k
   // time: O(Perm(n,k)); space: recursive stack
   public ArrayList<String> getPermutations(char[] s, int[] counts, int k){
      assert(k<s.length);
      ArrayList<String> res = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<s.length; i++){
         for (int j=0; j<counts[i]; j++)
            sb.append(s[i]);
      }
      dfs(sb.toString().toCharArray(), 0, k, res);
      return res;
   }
   private void dfs(char[] s, int dep, int k, ArrayList<String> res){
      if (dep==k){
         StringBuilder sb = new StringBuilder();
         for (int i=0; i<k; i++)
            sb.append(s[i]);
         res.add(sb.toString());
         return;
      }
      Set<Character> set = new HashSet<Character>();
      for (int i=dep; i<s.length; i++){
         if (set.contains(s[i]))
            continue;
         set.add(s[i]);
         swap(s, dep, i);
         dfs(s, dep+1, k, res);
         swap(s, dep, i);
      }
   }
   
   private void swap(char[] s, int i, int j){
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
   }
   
   @Test
   public void test(){
      char[] s = new String("abc").toCharArray();
      int[] counts = new int[]{2,1,3};
      System.out.println(getPermutations(s, counts, 2).toString());
   }
}
