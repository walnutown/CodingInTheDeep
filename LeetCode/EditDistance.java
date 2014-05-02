/*
    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
*/

// Levenshtein distance 
// a string metric for measuring the difference
// between two sequences. Informally, the Levenshtein distance between two
// words is the minimum number of single-character edits (i.e. insertions,
// deletions or substitutions) required to change one word into the other. The
// phrase edit distance is often used to refer specifically to Levenshtein
// distance

// Another string distance measurement is Hamming distance, only allows substitions

// DP
// word1.substring(0, i) can be converted into word2.substring(0, j) using mem[i][j] steps
// mem[i][j] = mem[i][j-1], denotes a insertion operation in word1.substring
// mem[i][j] = mem[i-1][j], denotes an deletion operation in word1.substring
// mem[i][j] = mem[i-1][j-1], denotes an replace operation in word1.substring
// time: O(m*n); space: O(m*n)
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null){
            if (word1==null && word2==null) return 0;
            return word1==null ? word2.length() : word1.length();
        }
        int M = word1.length(), N = word2.length();
        int[][] dp = new int[M+1][N+1];
        for (int i=1; i<=M; i++)
            dp[i][0] = i;
        for (int i=1; i<=N; i++)
            dp[0][i] = i;
        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
            }
        }
        return dp[M][N];
    }
}
