// DP, although TLE, this solution can find all the scramble strings of s1
// O(2^n * 2^n)
// Submission Result: Time Limit Exceeded
// Last executed input:    "bcabcbbbbabaacbaa", "cabaacbaabbacbbbb"
public class Solution {
    public boolean isScramble(String s1, String s2) {
      if (s1 == null || s2 == null)
         return s1 == null && s2 == null;
      int l1 = s1.length(), l2 = s2.length();
      if (l1 != l2)
         return false;
      Map<Integer, Set<StringBuilder>> mem1 = new HashMap<Integer, Set<StringBuilder>>();
      Map<Integer, Set<StringBuilder>> mem2 = new HashMap<Integer, Set<StringBuilder>>();
      mem1.put(0, new HashSet<StringBuilder>());
      mem1.get(0).add(new StringBuilder(""));
      for (int i = 1; i <= l1; i++) {
         mem1.put(i, new HashSet<StringBuilder>());
         for (StringBuilder sb : mem1.get(i - 1)) {
            StringBuilder tmp1 = new StringBuilder(sb);
            tmp1.append(s1.charAt(i-1));
            mem1.get(i).add(tmp1);
            if (i > 1 && s1.charAt(i-1) != s1.charAt(i - 2)) {
               StringBuilder tmp2 = new StringBuilder(sb);
               tmp2.insert(0, s1.charAt(i-1));
               mem1.get(i).add(tmp2);
            }
         }
      }
      mem2.put(l1+1, new HashSet<StringBuilder>());
      mem2.get(l1+1).add(new StringBuilder(""));
      for (int j=l1; j>0; j--){
         mem2.put(j, new HashSet<StringBuilder>());
         for (StringBuilder sb : mem2.get(j + 1)) {
            StringBuilder tmp1 = new StringBuilder(sb);
            tmp1.insert(0, s1.charAt(j-1));
            mem2.get(j).add(tmp1);
            if (j < l1  && s1.charAt(j-1) != s1.charAt(j)) {
               StringBuilder tmp2 = new StringBuilder(sb);
               tmp2.append(s1.charAt(j-1));
               mem2.get(j).add(tmp2);
            }
         }
      }
      for (int i = 0; i <= l1; i++) {
         for (StringBuilder left : mem1.get(i)) {
            for (StringBuilder right : mem2.get(i+1)) {
               if (s2.equals(left.toString() + right.toString()))
                  return true;
            }
         }
      }
      return false;
    }
}

// recursion, from Sophie, O(2^n)
// TLE
public class Solution {
    public boolean isScramble(String s1, String s2){
        if (s1==null || s2==null)   return s1==null && s2==null;
        int len = s1.length(), l2 = s2.length();
        if (len != l2)   return false;
        if (s1.equals(s2))  return true;
        for (int i=1; i<len; i++){
            String s1l = s1.substring(0, i), s1r = s1.substring(i,len);
            // w/o swap
            String s2l = s2.substring(0, i), s2r = s2.substring(i, len);
            if (isScramble(s1l, s2l) && isScramble(s1r, s2r))   return true;
            // w/ swap
            s2l = s2.substring(len-i); s2r = s2.substring(len-i, len);
            if (isScramble(s1l, s2r) && isScramble(s1r, s2l))   return true;
        }
        return false;
    }
}

// Accepted, 3-array DP, modified from AnnieKim, O(n^4)
//  'dp[k][i][j] == true' means string s1(start from i, length k) is 
//  a scrambled string of string s2(start from j, length k).
public class Solution {
    public boolean isScramble(String s1, String s2){
        if (s1==null || s2==null)   return s1==null && s2==null;
        int len = s1.length(), l2 = s2.length();
        if (len != l2)   return false;
        boolean[][][] dp = new boolean[len+1][len][len];
        for (int k=1; k<=len; k++){
            for (int i=0; i<=len-k; i++){
                for (int j=0; j<=len-k; j++){
                    if (k==1)   dp[1][i][j] = (s1.charAt(i)==s2.charAt(j));
                    for (int p=1; p<k && !dp[k][i][j]; p++)
                        dp[k][i][j] = dp[p][i][j] && dp[k-p][i+p][j+p] || dp[k-p][i+p][j] && dp[p][i][j+k-p];
                }
            }
        }
        return dp[len][0][0];
    }
}













