package facebook;

import org.junit.Test;

public class LongestCommonSubsequence {
   
   /**
    * Given two sequences, find the length of longest subsequence present in both of them. A
    * subsequence is a sequence that appears in the same relative order, but not necessarily
    * contiguous. For example, abc, abg, bdf, aeg, acefg, .. etc are subsequences of
    * abcdefg. 
    */
   // A string of length n has 2^n different possible subsequences.
   // Use case: 'diff'
   
   // Dynamic Programming
   // Maintain a 2d matrix to store the longest common subsequence
   // dp[i][j] holds the longest common subsequence of string a.substring(0,i) and b.substring(0,j)
   // time: O(m*n); space: O(m*n*Min(m,n))
   public String findLongestCommonSubsequence(String a, String b){
   		if (a==null || b==null)
   			return "";
   		int M = a.length(), N = b.length();
   		String[][] dp = new String[M+1][N+1];
   		for (int i=0; i<=M; i++)
   		   dp[i][0] = "";
   		for (int j=0; j<=N; j++)
   		   dp[0][j] = "";
   		for (int i=1; i<=M; i++){
   			for (int j=1; j<=N; j++){
   				if (a.charAt(i-1)==b.charAt(j-1)){
   					dp[i][j] = dp[i-1][j-1] + a.substring(i-1,i);
   				}else
   					dp[i][j] = dp[i-1][j].length()> dp[i][j-1].length()?dp[i-1][j] : dp[i][j-1];
   			}
   		}
   		return dp[M][N];
   }

   @Test
   public void test(){
   		String a = "abcdefg", b = "adegm";
   		System.out.println(findLongestCommonSubsequence(a,b));
   }
   
}
