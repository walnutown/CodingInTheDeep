/*
    Implement strStr().

    Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

// naive implementation
// time: O(n*(m-n+1)); space: O(1)
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack==null || needle==null) return null;
        char[] H = haystack.toCharArray(), N = needle.toCharArray();
        if (N.length==0)     return haystack;
        int i,j;
        for (i=0; i<=H.length-N.length; i++){       // notice 'H.length-N.length' here
            if (H[i] != N[0])   continue;
            for (j=1; j<N.length ; j++){
                if (H[i+j] != N[j])     break;
            }
            if (j==N.length)    return haystack.substring(i);
        }
        return null;
    }
}

/*
* the Knuth–Morris–Pratt string searching algorithm (or KMP algorithm) searches for occurrences
* of a "word" W within a main "text string" S by employing the observation that when a mismatch
* occurs, the word itself embodies sufficient information to determine where the next match
* could begin, thus bypassing re-examination of previously matched characters.
*/
// refer http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
// Pattern search is frequently used when you press Ctrl+F. The running time of naive 
// solution is O(n*(n-m+1))

// Each time, when we find a mismatch, we try to find the last longest matched prefix (llmp),
// and start next comparison from the end of llmp.
// Pre-processing time is O(m), worst case matching time is O(n)
// time: O(m+n)
 
 public class Solution {
    public String strStr(String haystack, String needle) {
        // KMP alogrithm, O(n + m)
        if (needle == null || haystack == null)
            return null;
        if (needle.length() == 0)
            return haystack;
        // needle.length() > 0 ,here
        if (haystack.length() == 0)
            return null;
        char[] H = haystack.toCharArray(), N = needle.toCharArray();
        int[] T = buildKMPTable(N);
        int i=0, j=0;
        while (i < H.length){
            if (H[i]==N[j]){
                i++; j++;
            }else{
                if (j>0)    j = T[j-1]; 
                else    i++;
            }
            if (j==N.length)    return haystack.substring(i-j);
        }
        return null;
    }
    
    // find match patterns in String N itself
    private int[] buildKMPTable(char[] N){
        int[] T = new int[N.length];
        int i=1, j=0;
        while (i<N.length){
            if (N[i]==N[j])
                T[i++] = ++j; // since we start next comparison after the end of llmp, we need to increment j fisrt
            else{
                if (j>0)    j = T[j-1];
                else    i++;
            }
        }
        return T;
    }
}   
    