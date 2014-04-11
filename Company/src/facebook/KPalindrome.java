package facebook;

import java.util.Arrays;

import org.junit.Test;

public class KPalindrome {
   /*
    * A k-palindrome is a string which transforms into a palindrome on removing at most k
    * characters.
    * Given a string S, and an integer K, print "YES" if S is a k-palindrome; otherwise print "NO".
    * Constraints:
    * S has at most 20,000 characters.
    * 0<=k<=30
    * Sample Test Case#1:
    * Input - abxa 1
    * Output - YES
    * Sample Test Case#2:
    * Input - abdxa 1
    * Output - No
    */
   // refer http://www.careercup.com/question?id=6287528252407808

   // Sol1: naive one
   // We start from characters on head and tail, compare the two. If equal, check if
   // s.substring(head+1, tail-1) is a palindrome; otherwise, remove head or tail and recursively
   // check s.substring(head, tail-1) or s.substring(head+1, tail), simultaneously decrement k by 1
   // time: O(2^k)
   // This can be optimized using memoization

   // Sol2: Dynamic Programming, similar to dp solution of Leetcode/LongestPalindromicSubstring
   // dp[i][j] - number of deletions to make s.substring(i,j+1) a palindrome
   // time: O(N^2); space: O(N^2)
   public boolean isKPalindrome(String s, int k) {
      if (s == null || s.length() == 0)
         return false;
      int N = s.length();
      int[][] dp = new int[N][N];
      for (int len = 1; len <= N; len++) { // check substring of length from 1 to N
         for (int i = 0, j = i + len; j < N; i++, j++) { // i, j is the start and end index of
                                                         // substring
            if (s.charAt(i) == s.charAt(j) && (i + 1 <= j - 1))
               dp[i][j] = dp[i + 1][j - 1];
            else
               dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
         }
      }
      return dp[0][N - 1] <= k;
   }

   // Sol3:
   // This question is equal to: MinEditDistance between two strings (s and its reverse s') is less
   // than 2*K
   // Why? assume s can be converted into a palindrome p, using K deletions; also, p can be
   // converted to s'
   // using K insertions. In a sum, s can be converted to s' using K deletions and K insertions.
   // Another observation is that in the dp matrix, only positions no more than K away form the main
   // diagonal need to be considered, because we only allow K deletions and K insertions.
   // time: O(N*k); space: O(N^2)
   public boolean isKPalindrome2(String s, int k) {
      if (s == null || s.length() == 0)
         return false;
      int N = s.length();
      String sr = new StringBuilder(s).reverse().toString();
      int[][] dp = new int[N + 1][N + 1];
      for (int[] row : dp)
         Arrays.fill(row, Integer.MAX_VALUE); // Other cells are impossible, set them to MAX_VALUE
      for (int i = 0; i <= N; i++) {
         dp[0][i] = i;
         dp[i][0] = i;
      }
      for (int i = 1; i <= N; i++) {
         int start = Math.max(1, i - k), end = Math.min(N, i + k);
         for (int j = start; j <= end; j++) {
            if (s.charAt(i - 1) == sr.charAt(j - 1))
               dp[i][j] = dp[i - 1][j - 1];
            else
               dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
         }
      }
      return dp[N][N] <= 2 * k;
   }

   @Test
   public void test() {
      String s = "abxa";
      System.out.println(isKPalindrome(s, 1));
      System.out.println(isKPalindrome2(s, 1));
      String s1 = "abxda";
      System.out.println(isKPalindrome(s1, 1));
      System.out.println(isKPalindrome2(s1, 1));
   }

}
