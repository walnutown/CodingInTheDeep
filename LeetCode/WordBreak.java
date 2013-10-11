// Submission Result: Wrong Answer
// Input:  "bb", ["a","b","bbb","bbbb"]
// Output: false
// Expected:   true
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // we use backtrack here to search whether the solution exists, time complexity would be O(m ^ n)
        return backtrack(new StringBuilder(s), dict, 0, 0);
    }
    public boolean backtrack(StringBuilder sb, Set<String> dict, int start, int len){
       // goal state
       if (start == sb.length()){
            if (len == sb.length())
                return true;
            return false;
       }
        for (int i = 1; start + i <= sb.length(); i++){
            String curr = sb.substring(start, start + i);
            if (!dict.contains(curr)) continue;
            len += i;
            dict.remove(curr);   // no need remove here
            return backtrack(sb, dict, start + i, len);   // cannnot return here, case: "aaaaaaa", ["aaa", "aaaa"]
        }
        return false;
    }
}

// TLE
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // we use backtrack here to search whether the solution exists, time complexity would be O(m ^ n)
        return backtrack(new StringBuilder(s), dict, 0);
    }
    public boolean backtrack(StringBuilder sb, Set<String> dict, int start){
       // goal state
       if (start == sb.length()){
            return true;
       }
       boolean ret = false;
        for (int i = 1; start + i <= sb.length(); i++){
            String curr = sb.substring(start, start + i);
            if (!dict.contains(curr)) continue;
            ret = ret || backtrack(sb, dict, start + i);
        }
        return ret;
    }
}