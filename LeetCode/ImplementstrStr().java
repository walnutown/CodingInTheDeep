/*
    Implement strStr().

    Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

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

