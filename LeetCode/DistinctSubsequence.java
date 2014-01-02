// DFS
// TLE
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null) return 0;
        int[] num = new int[1];
        finder(S.toCharArray(), 0, T.toCharArray(), 0, num);
        return num[0];
    }
    public void finder(char[] s, int i, char[] t, int j, int[] num){
        if (j==t.length){
            num[0]++;
            return;
        }
        if (i==s.length)  return;
        for (int k=i; k<s.length; k++){
            if (s[k] != t[j]) continue;
            finder(s, i+1, t, j+1, num);
        }
    }
}


// Accepted
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null) return 0;
        int m=S.length(), n=T.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i=1; i<=m; i++)    dp[i][0] = 1;
        for (int j=1; j<=n; j++)    dp[0][j] = 0;
        for (int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if (S.charAt(i-1) == T.charAt(j-1)) dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; 
                else    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}
//http://blog.csdn.net/u011095253/article/details/9248121
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null) return 0;
        int m=T.length(), n=S.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i=1; i<=m; i++)    dp[i][0] = 0;
        for (int j=1; j<=n; j++)    dp[0][j] = 1;
        for (int i=1; i<=m; i++){                   // change order here, better for undersatnding
            for(int j=1; j<=n; j++){
                if (T.charAt(i-1) == S.charAt(j-1)) dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                else    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
// 1d DP, know the conditions of transform from 2d DP to 1d DP, and how to transfrom 
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null) return 0;
        int m=T.length(), n=S.length();
        int[] dp = new int[n+1];
        for (int j=0; j<=n; j++)    dp[j] = 1;
        for (int i=1; i<=m; i++){
            int prev = dp[0];
            dp[0] = 0;
            for(int j=1; j<=n; j++){
                int tmp = dp[j];
                if (T.charAt(i-1) == S.charAt(j-1)) dp[j] = dp[j-1] + prev;
                else    dp[j] = dp[j-1];
                prev = tmp;
            }
        }
        return dp[n];
    }
}