// trail #2, 
// Last executed input: "0000"
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use DFS to search for the successors satisfying the conditions 
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        DFS(0, 0, s, res, new StringBuilder());
        return res;
    }
    
    public void DFS(int dep, int index, String s, ArrayList<String> res, StringBuilder sb ){
        if (dep == 4){
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        
        for (int i = 1; i <= 3; i ++){
            if (i + index > s.length()) continue;
            int val = Integer.parseInt(s.substring(index, index+ i));
            if (val <= 255 && val >= 0){
                if (val > 0 && s.charAt(index) == '0') continue;
                sb.append(val);
                sb.append('.');
                DFS(dep + 1, index + i, s, res, sb);
                sb.delete(sb.length() - i - 1 ,sb.length());
            }
        }
    }
}
// time limit
// last execute: 1111111111111111111111111111111111111111111111111111
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use DFS to search for the successors satisfying the conditions 
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        DFS(0, 0, s, res, new StringBuilder());
        return res;
    }
    
    public void DFS(int dep, int index, String s, ArrayList<String> res, StringBuilder sb ){
        if (dep == 4 && index == s.length()){   // add condition here
            res.add(sb.substring(0, sb.length()-1).toString());  // remove the last point here
            return;
        }
        
        for (int i = 1; i <= 3; i ++){
            if (i + index > s.length()) continue;
            int val = Integer.parseInt(s.substring(index, index+ i));
            if (val <= 255 && val >= 0){
                if (i >= 2 && s.charAt(index) == '0') continue;
                sb.append(val);
                sb.append('.');
                DFS(dep + 1, index + i, s, res, sb);
                sb.delete(sb.length() - i - 1 ,sb.length());
            }
        }
    }
}
// Accepted
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use DFS to search for the successors satisfying the conditions 
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        DFS(0, 0, s, res, new StringBuilder());
        return res;
    }
    
    public void DFS(int dep, int index, String s, ArrayList<String> res, StringBuilder sb ){
        if (dep == 4){
            if (index == s.length())   // check index here, when dep > 4 , should return, no matter whether the string is the goal string
                res.add(sb.substring(0, sb.length()-1).toString());
            return;
        }  
        for (int i = 1; i <= 3; i ++){
            if (i + index > s.length()) continue;
            int val = Integer.parseInt(s.substring(index, index+ i));
            if (val <= 255 && val >= 0){
                if (i >= 2 && s.charAt(index) == '0') continue;
                sb.append(val);
                sb.append('.');
                DFS(dep + 1, index + i, s, res, sb);
                sb.delete(sb.length() - i - 1 ,sb.length());
            }
        }
    }
}

// Submission Result: Runtime Error

// Last executed input:    "0000"

// see the totally same error in trial2, WTF!
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        finder(s, 0, 1, res, new StringBuilder());
        return res;
    }
    
    public void finder(String s, int index, int dot, ArrayList<String> res, StringBuilder r){
        if (dot == 5){
            r.deleteCharAt(r.length()-1);                       // wrong here, should be deleted in "r.delete(r.length()-str.length()-1, r.length());"
            res.add(r.toString());
            return;
        }
        for (int i=1; i<=3 && index+i <= s.length(); i++){
            String str = s.substring(index, index+i);
            if (i > 1 && str.charAt(0) == '0') break;
            int num = Integer.parseInt(str);
            if (num >= 0 && num<=255){
                r.append(num);
                r.append('.');
                finder(s, index+i, dot+1, res, r);
                r.delete(r.length()-str.length()-1, r.length());
            }
        }
    }
}
// Accepted
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
            if (num >= 0 && num<=255){
                r.append(num);
                r.append('.');
                finder(s, index+i, dot+1, res, r);
                r.delete(r.length()-i-1, r.length());
            }
        }
    }
}