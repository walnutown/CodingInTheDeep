// dp

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // judge null
        int nullCount = 0;
        if (s1 == null){
            nullCount++;
        }
        if (s2 == null){
            nullCount++;
        }
        if (s3 == null){
            nullCount++;
        }
        
        if (nullCount < 3 && nullCount > 0){
            return false;
        }
        if (nullCount == 3){
            return true;
        }
        // judge length
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if(len1 == 0 && len2 == 0 && len3 == 0){
            return true;
        }
        
        if (len1 + len2 != len3){
            return false;
        }
        
        boolean[][] match = new boolean[len1+1][len2+1];
        match[0][0] = true;
        for (int i = 1; i <= len1; i ++){
            if (s1.charAt(i-1) == s3.charAt(i-1)){
                match[i][0] = true;
            }
            else{
                break;
            }
        }
        
        for (int j = 1; j <= len2; j++){
            if (s2.charAt(j-1) == s3.charAt(j-1)){
                match[0][j] = true;
            }
            else{
                break;
            }
        }
        
        for (int i = 1; i <= len1; i++){
            char ch1 = s1.charAt(i-1);
            for (int j = 1; j <= len2; j++){
                char ch2 = s2.charAt(j-1);
                char ch3 = s3.charAt(i+j-1);
                if (ch1 == ch3){
                    match[i][j] = match[i-1][j];
                }
                if (ch2 == ch3){
                    match[i][j] = match[i][j-1] || match[i][j]; // or the result of previous if()
                }
            }
        }
        
        return match[len1][len2];
             
    }
}

// recursive, pass large judge
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;
        if(s3.length()!=s1.length()+s2.length()) 
            return false;
        if(s1.length()!=0 && s2.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1) && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1)) || 
                isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else if(s1.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1));
        }
        else if(s2.length()!=0 && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else 
            return false;
    }
}

// 3d DP like scrambled string, O(n^3)
// TLE
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // omit null check
        int l1=s1.length(), l2=s2.length(), l3=s3.length();
          if (l1+l2 != l3)  return false;
          boolean[][][] dp =new boolean[l3+1][l1+1][l2+1];
          dp[0][0][0] = true;
          for (int i=1; i<=l1 && s1.substring(0,i).equals(s3.substring(0,i)); i++)   dp[i][i][0]=true;
          for (int i=1; i<=l2 && s2.substring(0,i).equals(s3.substring(0,i)); i++)   dp[i][0][i]=true;
          for (int k=1; k<=l3; k++){
              for (int i=1; i<=l1; i++){
                  for (int j=1; j<=l2; j++){
                      dp[k][i][j] = s1.charAt(i-1)==s3.charAt(k-1) && dp[k-1][i-1][j] || s2.charAt(j-1)==s3.charAt(k-1) && dp[k-1][i][j-1];
                  }
              }
          }
          return dp[l3][l1][l2];
    }
}
// Accepted, change string equal to char comparison
// test on Eclipse, 50ms and 46ms
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // omit null check
        int l1=s1.length(), l2=s2.length(), l3=s3.length();
          if (l1+l2 != l3)  return false;
          boolean[][][] dp =new boolean[l3+1][l1+1][l2+1];
          dp[0][0][0] = true;
          for (int i=1; i<=l1 && s1.charAt(i-1)==s3.charAt(i-1); i++)   dp[i][i][0]=true;
          for (int i=1; i<=l2 && s2.charAt(i-1)==s3.charAt(i-1); i++)   dp[i][0][i]=true;
          for (int k=1; k<=l3; k++){
              for (int i=1; i<=l1; i++){
                  for (int j=1; j<=l2; j++){
                      dp[k][i][j] = s1.charAt(i-1)==s3.charAt(k-1) && dp[k-1][i-1][j] || s2.charAt(j-1)==s3.charAt(k-1) && dp[k-1][i][j-1];
                  }
              }
          }
          return dp[l3][l1][l2];
    }
}

// Accepted, O(m*n)
// 2d DP, modified from AnnieKim, best solution to this problem
// dp[i][j] == true' means that there is at least one way to construct 
// the string s3[0...i+j-1] by interleaving s1[0...j-1] and s2[0...i-1].
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=1; i<=m && s1.charAt(i-1)==s3.charAt(i-1); i++)  dp[i][0] = true;
        for (int j=1; j<=n && s2.charAt(j-1)==s3.charAt(j-1); j++)  dp[0][j] = true;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                dp[i][j] = s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j] || s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}

// Accepted
// 1d DP, notice that for each A[i][j], we only need A[i-1][j] and A[i][j-1].
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3){
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) return false;
        // switch to save space if needed
        if (m < n){
            String tmp = s1; s1=s2; s2=tmp;
            m = s1.length(); n=s2.length();
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int j=1; j<=n && s2.charAt(j-1)==s3.charAt(j-1); j++)   dp[j] = true;
        for (int i=1; i<=m; i++){
            dp[0] = dp[0] && s1.charAt(i-1)==s3.charAt(i-1);
            for (int j=1; j<=n; j++){
                dp[j] = dp[j] && s3.charAt(i+j-1)==s1.charAt(i-1) || dp[j-1] && s3.charAt(i+j-1)==s2.charAt(j-1);
            }
        }
        return dp[n];
    }
}


// Recursion, TLE
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // omit null check
        int l1=s1.length(), l2=s2.length(), l3=s3.length();
        if (l1+l2 != l3)  return false;
        return checker(s1, 0, s2, 0, s3, 0);
    }
    public boolean checker(String s1, int i, String s2, int j, String s3, int k){
        int l1 = s1.length(), l2=s2.length(), l3=s3.length();
        if (k==l3) return i==l1 && j==l2;
        if (i==l1) return j<l2 && s2.substring(j, l2).equals(s3.substring(k,l3));
        if (j==l2)  return i<l1 && s1.substring(i, l1).equals(s3.substring(k,l3));
        return s1.charAt(i)==s3.charAt(k) && checker(s1, i+1, s2, j, s3, k+1) || s2.charAt(j)==s3.charAt(k) && checker(s1, i, s2, j+1, s3, k+1);
    }
}











