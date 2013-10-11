// runtime error
public class Solution {
    ArrayList<ArrayList<String>> resList;
    ArrayList<String> ipList;
    ArrayList<String> res;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<String>>();
        res = new ArrayList<String>();
        ipList = new ArrayList<String>();
        int len = s.length();
        if (len < 4){
            return ipList;
        }
        DFS(s, 0, 1);
        return ipList;
    }
    
    public void DFS(String s, int start, int depth){
        if (depth <= 4 && start >= s.length()){
            return;
        }
        if (depth == 4 && start < s.length()){
           if (isValid(s, start)){
                    resList.add(new ArrayList<String>(res));
                    printIP();
                }
           return;
        }
        
        for (int i = 1; i <= 3; i++){
            if (start + i <= s.length()){
                String curr = s.substring(start, start + i);
                res.add(curr);
                DFS(s, start+i, depth+1);
                res.remove(res.size()-1);
            }
        }
    }
    
    public boolean isValid(String s, int start){
        for (int i = 0; i < 3; i++){
            int curr = Integer.parseInt(res.get(i));
            if (curr > 255){
                return false;
            }
        }
        String last = s.substring(start, s.length());
        if (Integer.parseInt(last) > 255){
            return false;
        }
        
        return true; 
    }
    
    public void printIP(){
        for (int i = 0; i< resList.size(); i++){
            ArrayList<String> curr = resList.get(i);
            StringBuilder temp = new StringBuilder();
            for (int j =0; j < 4; j++){
                temp.append(curr.get(j));
                temp.append(".");
            }
            temp.deleteCharAt(temp.length()-1);
            ipList.add(temp.toString());
        }
    }
    
}

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