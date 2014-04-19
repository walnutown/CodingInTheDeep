package google;

import org.junit.Test;

public class MaxProductOfTwoDifferentWords {
   /*
    * Given a dictionary of words, how can we efficiently find a pair words s.t. they don't have
    * characters in common and product of their length is maximum?
    * For example:
    * S = { "abc", "cde", "f", "efh"}.
    * Here the pair satisfying the property mentioned in problem will be ("abc", "efh").
    */
   
   // Sol1
   // The naive solution is to get all pairs of words (n^2, n is the number of words), 
   // and for each pair, we have to check whether they have common characters (a, a is
   // the size of alphabet)
   // time: O(a*n^2); space: O(1)
   
   // Sol2
   // Assume the alphabet is small enough (eg, lowercase English characters, 26)
   // One optimization is to use bitmap to represent the occurring characters in the word
   // eg, abba -> 11, a->1, ac -> 101 
   // to check whether two words have common characters, we only need to AND two words' bitmap
   // time: preprocess O(n*m), query (n^2); space: O(n)
   
   // Sol3
   // Further optimization:
   // The key point is that we have 2^a bitmaps, we can get the longest word represented by each bitmap
   // http://www.quora.com/Algorithms/Given-a-dictionary-of-words-how-can-we-efficiently-find-a-pair-words-s-t-they-dont-have-characters-in-common-and-sum-of-their-length-is-maximum
   
   // Implementation of Sol2. Assume we only have lowercase characters, that is [a-z]
   public int getMaxProduct(String[] ss){
      int max = 0;
      for (int i=0; i<ss.length; i++){
         for (int j=i+1; j<ss.length; j++){
            if (!shareCommon(ss[i], ss[j]))
               max = Math.max(ss[i].length()*ss[j].length(), max);
         }
      }
      return max;
   }
   
   private int getBitmap(String s){
      int bitmap = 0;
      for (int i =0; i<s.length(); i++)
         bitmap |= (1<<(s.charAt(i)-'a'));
      return bitmap;
   }
   
   private boolean shareCommon(String a, String b){
      return (getBitmap(a) & getBitmap(b))>0;
   }
   
   @Test
   public void test(){
      String[] ss = new String[]{
            "dog", "cat", "apple", "orange"
      };
      System.out.println(getMaxProduct(ss));
   }
   
}
