public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len <= 1){
            return s;
        }
        String res = "";
        for (int i = 1; i < len; i++){
            for (int j = 0; j <i; j++){
                String p = s.substring(j, i+1);
                if (p.length() > res.length()){
                    if (isPalindrome(p)){
                        res = p;
                    }
                }
                else{
                    break;
                }
            }
        }        
        return res;
    }
    
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
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

