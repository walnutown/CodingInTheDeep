public class StringMatch {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      //System.out.println(Naive_UniqueP("aabbabcdab", "ab"));
      System.out.println(gapCharacter("aba", "bb"));
   }
   
   /**
    * Q32.1.2, can deduce the KMP
    * Suppose that all characters in the pattern P are different. 
    * Show how to accelerate NAIVE-STRING-MATCHER to run in time O(n) 
    * on an n-character text T 
    */
   public static int Naive_UniqueP(String T, String P) {
      // use brunning to effectively reduce search scope
      // gas station, max subarray
      int i = 0;
      int count = 0;
      while (i < T.length()) {
         int j = 0;
         while (j < P.length() && T.charAt(i + j) == P.charAt(j)){
            j++;
         }
         if (j == P.length())
            count++;
         i = j == 0? i+1 : i + j;
      }
      return count;
   }
   
   /**
    * Q32.1-4, easy version of leetcode regular expression match, the difference lies in that
    * we only need to check the occurance of the pattern, not to match the pattern with the whole text
    * pattern contains gap character '.' ( random string with length >= 0 )
    *       e.g. ab.a is in ccabcad
    * gap characet can occur an arbitrary number of times in the pattern 
    * but not at all the text.
    */
   public static boolean gapCharacter(String T, String P){
      if ( T == null || P == null)
         return T== null && P == null;
      // T = ""
      if (P.length() == 0)
         return true;
      if (T.length() == 0)
         return false;
      if (T.charAt(0) == P.charAt(0))
         return gapCharacter(T.substring(1), P.substring(1));
      if (P.charAt(0) == '.')
         return gapCharacter(T.substring(1), P.substring(1)) || gapCharacter(T.substring(1), P.substring(0));
      return gapCharacter(T.substring(1), P.substring(0));
   }
}
