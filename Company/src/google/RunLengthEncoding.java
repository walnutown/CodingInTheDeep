package google;

import org.junit.Test;

public class RunLengthEncoding {
   /*
    * Given an input string, write a function that returns the Run Length Encoded string for the
    * input string. Assume there's only alphabetic characters in the given string.
    */

   // http://www.geeksforgeeks.org/run-length-encoding/
   
   // Maintain a counter
   // time: O(n); space: O(1)
   public String runLengthEncode(String s){
      if (s==null || s.length()==0)
         return s;
      StringBuilder sb = new StringBuilder();
      int count = 1, i = 0, N = s.length();
      while (i<N){
         sb.append(s.charAt(i));
         int j = i+1;
         count = 1;
         while (j<N && s.charAt(j)==s.charAt(i)){
            j++;
            count++;
         }
         sb.append(count);
         i = j;
      }
      return sb.toString();
   }
   
   @Test
   public void test(){
      String s = "wwwwaaadexxxxxx";
      System.out.println(runLengthEncode(s));
   }
}
