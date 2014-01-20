/*
  Given a string s, partition s such that every substring of the partition is a palindrome.

  Return the minimum cuts needed for a palindrome partitioning of s.

  For example, given s = "aab",
  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

// 1d DP, TLE
// listed here for easier understanding of the following solution
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)   return 0;
        int[] mem = new int[s.length()+1];
        mem[0] = 0;
        mem[1] = 0;
        for (int i=2; i<=s.length(); i++){
            if (isPalindrome(s.substring(0, i)))    continue;
            mem[i] = i-1;
            for (int j=i-1; j>0; j--){
                if (isPalindrome(s.substring(j, i)))    mem[i] = Math.min(mem[i], mem[j]+1);
            }
        }
        return mem[s.length()];
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

// Two mixed DPs, one dp to store the palindrome checking, another to update the minimum cuts
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)   return 0;
        int[][] p = new int[s.length()][s.length()];
        int[] mem = new int[s.length()+1];
        mem[0] = -1;
        mem[1] = 0;
        for (int i=2; i<=s.length(); i++){
            mem[i] = i-1;
            for (int j=i-1; j>=0; j--){  // p[i][j] =1 if s.substring(i, j) is palindrome
                if (s.charAt(j)==s.charAt(i-1) && ( j>=i-2 || p[j+1][i-2]==1)){
                    p[j][i-1] = 1;
                    mem[i] = Math.min(mem[i], mem[j]+1);
                }
            }
        }
        return mem[s.length()];
    }
}

// refactor code, use 1d array for panlindrome checking
// AnnieKim
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)   return 0;
        int[] p = new int[s.length()+1]; 
        int[] mem = new int[s.length()+1];
        mem[0] = -1;
        for (int i=1; i<=s.length(); i++){
            p[i] = 1;
            mem[i] = i-1;
            for (int j=0; j<i; j++){
                if (s.charAt(j)==s.charAt(i-1) && p[j+1]==1){  
                    p[j] = 1; // p[j]=1 -> s[j, i-1] is Palindrome; p[j+1] -> s[j+1, i-2] is Palindrome
                    mem[i] = Math.min(mem[i], mem[j]+1);
                }else p[j] = 0;
            }
        }
        return mem[s.length()];
    }
}