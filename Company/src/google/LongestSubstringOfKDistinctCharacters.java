package google;

import org.junit.Test;

public class LongestSubstringOfKDistinctCharacters {
   /*
    * Given a string, find the longest substring with k distinct ASCII characters
    * if there's no such substring, return ""
    * eg, 
    * input: S = "DCABBBBBBACCC", k= 2
    * output: "ABBBBBBA"
    */
   // Maintain two pointers of sliding window's left and right border
   // Maintain a table to count the number of each distinct characters
   // When there're exactly k distinct characters, update the max substring
   // When we find there're k+1 distinct characters, shift left border until there're
   // only k distinct characters.
   // time: O(n); space: O(n)
   public String getLongestSub(String S, int k){
      if (S== null)
         return null;
      int N = S.length();
      if (N<k)
         return "";
      int[] set = new int[128];
      String max = "";
      int i=0, j=0;
      while (j<N){
         int ch = (int)S.charAt(j);
         if (set[ch]==0)
            k--;
         set[ch]++;
         if (k==0){
            String sub = S.substring(i, j+1);
            if (max.equals("") || max.length()<sub.length())
               max = sub;
         }
         else if (k==-1){
            i = getStartIndex(S, set, i);
            k=0;
         }
         j++;
      }
      return max;
   }
   
   private int getStartIndex(String S, int[] set, int i){
      while (i < S.length()){
         int ch = (int) S.charAt(i);
         set[ch]--;
         if (set[ch]>0)
            i++;
         else
            break;
      }
      return i+1;
   }
   
   @Test
   public void test(){
      String S = "DCABBBBBBACCC";
      int k= 2;
      System.out.println(getLongestSub(S, k));
   }
}
