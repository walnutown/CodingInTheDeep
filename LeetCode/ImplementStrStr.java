// Submission Result: Wrong Answer

// Input:  "mississippi", "issipi"
// Output: "ssippi"
// Expected:   null
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
        int[] kmp_tb = new int[needle.length()];
        buildKMPTable(needle, kmp_tb);
        int i = 0, j = 0;
        while (i + j < haystack.length()){
            if (haystack.charAt(i+j) == needle.charAt(j)){
                if (j == needle.length()-1)
                    return haystack.substring(i);
                j++;
            }else{
                i = i + j - kmp_tb[j];
                j = kmp_tb[j] > -1 ? kmp_tb[j] : 0;
            }
        }
        return null;
    }
    
    public void buildKMPTable(String needle, int[] kmp_tb){
        kmp_tb[0] = -1;
        int pos = 1, cnd = 0;
        while (pos < needle.length()){
            if (needle.charAt(pos-1) == needle.charAt(cnd)){
                kmp_tb[pos] = cnd; 
                cnd++;
                pos++;
            }else if (cnd > 0){
                cnd = kmp_tb[cnd];
            }else{
                kmp_tb[pos] = 0;
                pos++;
            }
        }
    }
}


// Accepted, Dec 24
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
        int[] kmp_tb = new int[needle.length()];
        buildKMPTable(needle, kmp_tb);
        int i = 0, j = 0;
        while (i + j < haystack.length()){
            if (haystack.charAt(i+j) == needle.charAt(j)){
                if (j == needle.length()-1)
                    return haystack.substring(i);
                j++;
            }else{
                i = i + j - kmp_tb[j];
                j = kmp_tb[j] > -1 ? kmp_tb[j] : 0;
            }
        }
        return null;
    }
    
    public void buildKMPTable(String needle, int[] kmp_tb){
        kmp_tb[0] = -1;
        if (needle.length() <= 1)   // notice here
            return;
        kmp_tb[1] = 0;
        int pos = 2, cnd = 0;
        while (pos < needle.length()) {
            if (needle.charAt(pos - 1) == needle.charAt(cnd)) {
                cnd++;
                kmp_tb[pos] = cnd;
                pos++;
            } else if (cnd > 0) {
                cnd = kmp_tb[cnd];
            } else {
                kmp_tb[pos] = 0;
                pos++;
            }
        }
    }
}