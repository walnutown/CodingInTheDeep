/*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

//  http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
//  The second solution uses a sliding window, is good. 
public class Solution {
       
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.length() < T.length()){
            return "";
        }
        
        Map<Character, Integer> hasFind = new HashMap<Character, Integer>();
        Map<Character, Integer> tm = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++){
            char curr = T.charAt(i);
            if (tm.containsKey(curr)){
                tm.put(curr, tm.get(curr) + 1);
            }
            else
                tm.put(curr, 1);
        }
        int minWidth = Integer.MAX_VALUE;
        String minStr = "";
        int start = 0, end =0;
        int count = 0;
        for (; end < S.length(); end++){
            char curr = S.charAt(end);
            if (!tm.containsKey(curr))
                continue;
                
            if (!hasFind.containsKey(curr)){
                hasFind.put(curr, 1);
                count++;
            }
            else{
                hasFind.put(curr, hasFind.get(curr) + 1);
                if (hasFind.get(curr) <= tm.get(curr))
                    count++;
            }
        
            if (count == T.length()){
                char startCh = S.charAt(start);
                while (!tm.containsKey(startCh) || hasFind.get(startCh) > tm.get(startCh)){
                    if (!tm.containsKey(startCh))
                        start++;
                    else{
                        hasFind.put(startCh, hasFind.get(startCh) -1);
                        start++;
                    }
                    startCh = S.charAt(start);
                }
                int width = end - start + 1;
                if (width < minWidth){
                    minWidth = width;
                    minStr = S.substring(start, end+1);
                }
            }
        }
        
        return minStr;
    }
}

// modified from AnnieKim
public class Solution {
    public String minWindow(String S, String T) {
        if (S==null || T==null) return "";
        int m = S.length(), n=T.length();
        if (m==0 || n==0 || m<n)   return "";
        return minWindow(S.toCharArray(), T.toCharArray());
    }
    public String minWindow(char[] S, char[] T){
        int[] need = new int[256];
        int[] find = new int[256];
        int m=S.length, n=T.length;
        for (int i=0; i<n; i++) need[T[i]]++;
        int count=0, r_start = -1, r_end = m;
        for (int start=0, end=0; end<m; end++){
            if (need[S[end]]==0)    continue;
            if (find[S[end]] < need[S[end]])    count++;
            find[S[end]]++;
            if (count < n)   continue;
            // move 'start'
            for (; start<end; start++){
                if (need[S[start]]==0)  continue;
                if (find[S[start]] <= need[S[start]])   break;
                find[S[start]]--;
            }
            // update result
            if (end-start < r_end - r_start){
                r_start = start;
                r_end = end;
            }
        }
        return r_start==-1 ? "" : String.valueOf(S, r_start, r_end-r_start+1);  // valueOf(char[] data, int offset, int count)
    }
}

























