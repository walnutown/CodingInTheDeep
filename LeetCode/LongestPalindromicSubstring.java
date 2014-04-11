/*
    Given a string S, find the longest palindromic substring in S. 
    You may assume that the maximum length of S is 1000, and there
    exists one unique longest palindromic substring.
*/

// brute force
// use three loops, the first two loops pick the starting and ending index of the substring
// the thrid loop checks whether the substring is a palindrome
// time: O(n^3); space: O(1)
    

// Dynamic Programming
// we have duplicate calculations when we do the palindrome checking step in the brute force
// solution. This reminds us to use memoization to avoid the duplicate calculaiton. In this
// case, each substring is checked exactly once
// time: O(n^2); space: O(n^2)

public class Solution {
    public String longestPalindrome(String s) { 
        if (s==null || s.length()==0)
            return "";
        int N = s.length();
        boolean[][] isP = new boolean[N][N]; // whether the substring [i,j] is a palindrome
        String max = s.substring(0,1);
        // substrings of length 1 are palindrome
        for (int i=0; i<N; i++)
            isP[i][i] = true;
        // check for lengths greater than 1
        for (int len=2; len<=N; len++){
            for (int i=0, j=i+len-1; j<N; i++, j++){
                if (s.charAt(i)==s.charAt(j) && (i+1>j-1 || isP[i+1][j-1])){
                    isP[i][j] = true;
                    if (len>max.length())
                        max = s.substring(i, j+1);
                }
            }
        }
        return max;
    }
}

// Fix a center, and expand from both direcitons to find palindromes
// there're two cases: the palindrome is odd length, or even length
// time: O(n^2), space: O(1)
public class Solution {
    public String longestPalindrome(String s) {  
        String longest = "";  
        for (int i=0; i<s.length(); ++i) {  
            String palindrome = findPalindrome(s, i, i);  
            if (palindrome.length() > longest.length()) {  
                longest = palindrome;  
            }  
        }  
        for (int i=1; i<s.length(); ++i) {  
            String palindrome = findPalindrome(s, i-1, i);  
            if (palindrome.length() > longest.length()) {  
                longest = palindrome;  
            }  
        }  
        return longest;  
    } 

    public String findPalindrome(String s, int left, int right) {  
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {  
            left--; right++;  
        }  
        return s.substring(left+1, right);  
    }  
}

// Manacher's algorithm, time: O(n); space: O(n)
// http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";
        char[] T = preProcess(s).toCharArray();
        int n = T.length, c = 0, r = 0;
        int[] p = new int[n];
        // p[i] indicate the max length palidrome which t[i] is the center
        for (int i = 1; i<n-1 ; i++) {
            int i_mirror = 2 * c - i; // equals to i' = C - (i-C)
            p[i] = (r > i) ? Math.min(r - i, p[i_mirror]) : 0;
            // Attempt to expand palindrome centered at i
            while (T[i + 1 + p[i]] == T[i - 1 - p[i]]) // no need of bound cehcking here due to '^' and '$'
                p[i]++;
            // If palindrome centered at i expand past R,
            // adjust center based on expanded palindrome.
            if (i + p[i] > r) {
                c =i;
                r = i + p[i];
            }
        }
        int maxLen =0;
        int centerIndex =0;
        for(int i =1; i< n-1; i++){
            if(p[i]> maxLen){
                maxLen = p[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex -1- maxLen)/2, (centerIndex -1+ maxLen)/2);
    }
    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking
    public static String preProcess(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (int i = 0; i < n; i++) {
            sb.append("#" + s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }

