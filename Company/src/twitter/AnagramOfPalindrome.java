package twitter;

public class AnagramOfPalindrome {
   /*
    * A String A is a palindrome if it has exactly the same sequence of characters when read left to right
    * as it has when read right-to-left.For example, the following strings are palindrome 
    * kayak",
    * "codilitytilidoc",
    * "neveroddoreven".
    * A string A is an anagram of a string B if A can be obtained from B by rearranging the
    * characters. For example, in each of the following pairs one string is an anagram of the other:
    * "mary" and "army",
    * "rocketboys" and "octobersky",
    * "codility" and "codility".
    * Write a function:
    * class Solution { public int solution(String S); }
    * that, given a non-empty string S consisting of N characters, returns 1 if S is an anagram of
    * some palindrome and returns 0 otherwise.
    * Assume that:
    * N is an integer within the range [1..100,000];
    * string S consists only of lower-case letters (a−z).
    * For example, given S = "dooernedeevrvn", the function should return 1, because
    * "dooernedeevrvn" is an anagram of the palindrome "neveroddoreven". Given S = "aabcba", the
    * function should return 0.
    * Complexity:
    * expected worst-case time complexity is O(N);
    * expected worst-case space complexity is O(1) (not counting the storage required for input
    * arguments).
    */
   
   public boolean isAnagramOfPalindrome(String S){
      int digits = 0;
      for (int i=0; i<S.length(); i++){
         int ch = S.charAt(i)-'a';
         digits ^= (1<<ch);
      }
      int count = 0;
      for (int i=0; i<26; i++){
         if (((digits>>i)&1)==1)
            count++;
      }
      return count >= 2;
   }
}
