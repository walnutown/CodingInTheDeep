package ch1_arrays_strings;

public class KMPStringMatch {
   /*
    * the Knuth–Morris–Pratt string searching algorithm (or KMP algorithm) searches for occurrences
    * of a "word" W within a main "text string" S by employing the observation that when a mismatch
    * occurs, the word itself embodies sufficient information to determine where the next match
    * could begin, thus bypassing re-examination of previously matched characters.
    */
   // refer http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
   // Pattern search is frequently used when you press Ctrl+F. The running time of naive 
   // solution is O(n*(n-m+1))
   
   // Pre-processing time is O(m), worst case matching time is O(n)
   
   /**
    * search W in S, return the starting index of the matched pattern
    */
   public int search(char[] S, char[] W){
      int m = 0; // the beginning of the current match in S
      int i = 0; // the position of the current character in W
      
      int[] T = buildTable(S, W);
      while (m+i < S.length){
         if (W[i] == S[m+i]){
            if (i == W.length-1)
               return m;
            i++;
         }else{
            m = m + i-T[i];
            i = T[i]>-1? T[i]:0;
         }
      }
      return S.length;
   }
}
