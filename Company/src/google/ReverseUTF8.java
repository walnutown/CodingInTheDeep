package google;

public class ReverseUTF8 {
   /*
    * A character can be represented as 1-6 bytes using UTF8 encoding
    * http://en.wikipedia.org/wiki/UTF-8
    * eg,
    * '$' -> Hexadecimal UTF8: 24 -> Binary UTF8: 00100100
    * '¢' -> Hexadecimal UTF8: C2 A2 -> Binary UTF8: 11000010 10100010
    * given a string S encoded as a byte array,
    * and isUTF8Start(int byteIndex)
    * which checks whether the byte is the starting of a valid hexadecimal UTF8
    * Now implement the function reverse(Byte[] src), which gets the byte array
    * of the reversed string of S
    */

   public boolean isUTF8Start(byte b) {
      return false;
   }

   // This question is similar to Leetcode/reverseWordsInString
   // The difference lies in that we don't have whitespace as delimiter
   // [1] reverse each subarray of a single UTF8 code
   // [2] reverse the whole array
   public byte[] reverse(byte[] src) {
      int N = src.length, i = 0, j = 1;
      while (j < N) {
         if (isUTF8Start(src[j])) {
            reverseRange(src, i, j - 1);
            i = j;
         }
         j++;
      }
      reverseRange(src, i, j - 1);
      reverseRange(src, 0, N - 1);
      return src;
   }

   private void reverseRange(byte[] src, int start, int end) {
      while (start <= end) {
         Byte tmp = src[start];
         src[start] = src[end];
         src[end] = tmp;
         start++;
         end--;
      }
   }
}
