// Accepted
// from Sophie, time: O(n^2), space: O(1)
public class Solution {
    public String findPalindrome(String s, int left, int right) {  
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {  
            left--; right++;  
        }  
        return s.substring(left+1, right);  
    }  
   
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
}


// O(n)
public static String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.isEmpty())
            return new String();
        String t = preProcess(s);
        int n = t.length(), c = 0, r = 0;
        int[] p = new int[n];

        // p[i] indicate the max length palidrome which t[i] is the center
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * c - i;
            p[i] = (r > i) ? Math.min(r - i, p[i_mirror]) : 0;
            //System.out.println("Current i:"+i+" r: "+r+" c: "+c+" p[i]: "+p[i]);
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i]))
                p[i]++;
            //System.out.println("After expand p[i]: "+p[i]);
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

