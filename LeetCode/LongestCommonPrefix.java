/*
    Write a function to find the longest common prefix string amongst an array of strings.
*/

// use the first string as the base, and compare each char with chars in other strings
// Note strings may have different lengths. So, rememebr to check the length of the string
// time: O(m*n), space: O(n). m is the number of strings, n is the length of the longest string
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0)   return "";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++){
                if (i>=strs[j].length() || strs[j].charAt(i)!=ch) // Remember to check string length here
                   return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}