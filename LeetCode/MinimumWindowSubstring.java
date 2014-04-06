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

// Sliding Window 
// Maintain two arrays to record the occurrences of needed characters and found characters 
// Traverse the String S, update the occurrence arrays and the number of remaining chars that need to be found.
// When all needed chars haven been found, right shift the start index of window if possible, 
// and update the min window.
// time: O(n); space: O(n), each char is accessed at most twice
public class Solution {
    public String minWindow(String S, String T) {
        if (S==null || T==null)
            return "";
        int M = S.length(), N = T.length();
        if (M<N)
            return "";
        int[] need = new int[256], find = new int[256];
        for (int i=0; i<N; i++)
            need[T.charAt(i)-'0']++;
        int start = 0, minStart = -1, minEnd = M; // make sure the initial value of minEnd-minStart is big enough
        for (int i=0; i<M; i++){
            int ch = S.charAt(i)-'0';
            if (find[ch]<need[ch])
                N--;
            find[ch]++;
            if (N==0){
                start = getStartIndex(need, find, S, start);
                if (i-start<minEnd-minStart){
                    minEnd = i; minStart = start;
                }
            }
        }
        return minStart==-1?"": S.substring(minStart, minEnd+1);
    }
    
    private int getStartIndex(int[] need, int[] find, String S, int oldStart){
        int i = oldStart;
        for (; i<S.length(); i++){
            int ch = S.charAt(i)-'0';
            if (find[ch]>need[ch])
                find[ch]--;
            else
                break;
        }
        return i;
    }
}

























