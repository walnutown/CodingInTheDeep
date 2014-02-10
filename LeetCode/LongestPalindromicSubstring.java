/*
    Given a string S, find the longest palindromic substring in S. 
    You may assume that the maximum length of S is 1000, and there
    exists one unique longest palindromic substring.
*/

// from Sophie, time: O(n^2), space: O(1)
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

