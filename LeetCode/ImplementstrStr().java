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

// Pre-processing time is O(m), worst case matching time is O(n)
// time: O(m+n)
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle == null || haystack == null)
            return null;
        if (needle.length() == 0)
            return haystack;
        if (haystack.length() == 0)
            return null;
        char[] S = haystack.toCharArray(), W = needle.toCharArray();
        int[] T = buildKMPTable(W);
        int m = 0, i = 0;
        while (m + i < S.length){
            if (S[m+i] == W[i]){
                if (i == W.length-1)
                    return haystack.substring(m);
                i++;
            }else{
                m = m + i - T[i];
                i = T[i] > -1 ? T[i] : 0;
            }
        }
        return null;
    }
    
    public int[] buildKMPTable(char[] W){
        int[] T = new int[W.length];
        T[0] = -1;
        if (W.length <= 1)   // avoid IndexOutOfBoundException
            return T;
        T[1] = 0;
        int i = 2, j = 0;
        while (i < W.length) {
            if (W[i - 1] == W[j]) { // match continues
                T[i] = ++j;
                i++;
            } else {
                if (j > 0) // no match, but we can fall back
                    j = T[j];
                else // run out of candidates
                    T[i++] = 0; 
            }
        }
        return T;
    }
}
