/*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

// Backtracking
// Use dot as delimiter to partition the string into 4 parts
// Note the range of a partition is [0,255], and 00 or 000 is not allowed
// time: O(Com(n,3))
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s==null || s.length() == 0) return res;
        finder(s, 0, 1, res, new StringBuilder());
        return res;
    }
    
    public void finder(String s, int index, int dot, ArrayList<String> res, StringBuilder r){
        if (dot == 5){
            if (index == s.length())    res.add(r.substring(0, r.length()-1).toString());       // important, should check length here
            return;
        }
        for (int i=1; i<=3 && index+i <= s.length(); i++){
            String str = s.substring(index, index+i);
            if (i > 1 && str.charAt(0) == '0') break;
            int num = Integer.parseInt(str);
            if (num>=0 && num<=255){
                r.append(num);
                r.append('.');
                finder(s, index+i, dot+1, res, r);
                r.delete(r.length()-i-1, r.length());
            }
        }
    }
}