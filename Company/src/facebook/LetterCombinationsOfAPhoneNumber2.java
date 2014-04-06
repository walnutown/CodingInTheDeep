package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LetterCombinationsOfAPhoneNumber2 {
   /*
    * Given a digit string, return all possible letter combinations that the number could represent.
    * 1 -> ""
    * 2 -> ABC
    * 3 -> DEF
    * 4 -> GHI
    * 5 -> JKL
    * 6 -> MNO
    * 7 -> PQRS
    * 8 -> TUV
    * 9 -> WXYZ
    * input: 223
    * output :ouput = [AAD, BBD, CCD, AAE, AAF, BBE, BBF, CCE, CCF]
    * This is a variant of Leetcode/LetterCombinationsOfAPhoneNumber
    * Difference lies in that the same number should be mapped to same character
    * eg, ABD is invalid
    */

   public ArrayList<String> getLetterCombinations(Map<Integer, String> map, int N) {
      ArrayList<String> res = new ArrayList<String>();
      if (N == 0)
         return res;
      char[] A = new char[10];
      Arrays.fill(A, '0');
      getter(map, A, N, res, new String());
      return res;
   }

   private void getter(Map<Integer, String> map, char[] A, int N, ArrayList<String> res, String r) {
      if (N == 0) {
         res.add(r);
         return;
      }
      int digit = N % 10;
      N /= 10;
      if (A[digit] != '0') {
         getter(map, A, N, res, A[digit]+r);
         return;
      }
      String s = map.get(digit);
      if (s.length()==0){
         getter(map, A, N, res, r);
         return;
      }
      for (int i = 0; i < s.length(); i++) {
         A[digit] = s.charAt(i);
         getter(map, A, N, res, A[digit]+r);
      }
      A[digit] = '0'; // Don't forget this step
   }

   @Test
   public void test() {
      Map<Integer, String> map = new HashMap<Integer, String>();
      map.put(1, "");
      map.put(2, "abc");
      map.put(3, "def");
      map.put(4, "ghi");
      map.put(5, "jkl");
      map.put(6, "mno");
      map.put(7, "pqrs");
      map.put(8, "tuv");
      map.put(9, "wxyz");
      map.put(0, " ");
      System.out.println(getLetterCombinations(map, 62266));
   }

}
