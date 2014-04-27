/*
  Given a string s, partition s such that every substring of the partition is a palindrome.

  Return all possible palindrome partitioning of s.

  For example, given s = "aab",
  Return

    [
      ["aa","b"],
      ["a","a","b"]
    ]
*/

// Basic Backtracking
// We can cut or not cut at each character, thus there're 2^n combinations.
// Each combination calls isPalindrome, which takes O(n)
// time: O(n*2^n); space: recursive stack
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)   return res;
        finder(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    public void finder(String s, int index, ArrayList<ArrayList<String>> res, ArrayList<String> r){
        if (index == s.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        for (int i = index; i < s.length(); i++){
            String w = s.substring(index, i+1);
            if (isPalindrome(w)){
                r.add(w);
                finder(s, i+1, res, r);
                r.remove(r.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String w){
        if (w == null || w.length() == 0)   return false;
        int i = 0, j = w.length()-1;
        while (i < j)
            if (w.charAt(i++) != w.charAt(j--)) return false;
        return true;
    }
}

// Dynamic Programming
// dp[i] -- all the valid partions in s.substring(0, i)
// We can also use a boolean matrix here to reduce palindrome checking time from O(n) to O(1)
// time: O(n*2^n); space: O(2^n)
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s==null || s.length()==0)
            return new ArrayList<ArrayList<String>>();;
        Map<Integer, ArrayList<ArrayList<String>>> dp = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        int N = s.length();
        for (int i=0; i<=N; i++)
            dp.put(i, new ArrayList<ArrayList<String>>());
        dp.get(0).add(new ArrayList<String>());
        for (int i=1; i<=N; i++){
            for (int j=1; j<=i; j++){
                String sub = s.substring(j-1, i);
                if (isPalindrome(sub)){
                    for (ArrayList<String> list:dp.get(j-1)){
                        ArrayList<String> r = new ArrayList<String>(list);
                        r.add(sub);
                        dp.get(i).add(r);
                    }
                }
            }
        }
        return dp.get(N);
    }      
    private boolean isPalindrome(String s){
        if (s==null || s.length()==0)
            return false;
        for (int i=0, j=s.length()-1; i<j; i++, j--){
            if (s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }   
}