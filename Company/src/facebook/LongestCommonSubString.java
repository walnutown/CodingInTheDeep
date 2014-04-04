package facebook;

import org.junit.Test;

public class LongestCommonSubString {
   /*
    * Given two strings a and b, find the length of the longest common substring. For example,
    * if the given strings are GeeksforGeeks and GeeksQuiz, the output should be 5 as longest
    * common substring is Geeks
    */

   // refer http://www.geeksforgeeks.org/longest-common-substring/
   // Dynamic Programming
   // Maintain a 2d matrix stroing common substrings
   // dp[i][j] holds the longest common suffix of two substrings with length i and j
   // time: O(m*n); space: O(m*n*Min(m,n))
   public String findLCS(String a, String b) {
      if (a == null || b == null)
         return "";
      int M = a.length(), N = b.length();
      if (M == 0 || N == 0)
         return "";
      String[][] dp = new String[M + 1][N + 1];
      String lcs = "";
      for (int i = 0; i < M; i++)
         dp[i][0] = "";
      for (int j = 0; j < N; j++)
         dp[0][j] = "";
      for (int i = 1; i <= M; i++) {
         for (int j = 1; j <= N; j++) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + a.substring(i-1, i);
               if (lcs.length() < dp[i][j].length())
                  lcs = dp[i][j];
            } else
               dp[i][j] = "";
         }
      }
      return lcs;
   }

   @Test
   public void test() {
      String a = "GeeksforGeeks", b = "GeeksQuiz";
      System.out.println(findLCS(a, b));
   }
}
