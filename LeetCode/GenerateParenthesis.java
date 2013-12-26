public class Solution {
    ArrayList<String> res;
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<String>();
        if (n == 0){
            res.add("");
            return res;
        }
        generator(n, 0, 0, "");
        return res;
        
    }
    
    public void generator(int n, int left, int right, String s){
        if (left > n || right > n || right > left){
            return;
        }
        if (left == right && left == n){
            res.add(s);
            return;
        }
        
        generator(n, left+1, right, s+"(");
        generator(n, left, right+1, s+")");
    }
}



// Accepted, Dec 24
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        finder(0, res, new StringBuilder(), n);
        return res;
    }
    
    public void finder(int left, ArrayList<String> res, StringBuilder sb, int count){
        if (count == 0){
            if (left == 0)  res.add(sb.toString());
            return;
        }
        if (left == 0){
            sb.append('(');
            finder(left+1, res, sb, count);
            sb.deleteCharAt(sb.length()-1);
        }else if (left > 0 && left <= count){
            sb.append('(');
            finder(left+1, res, sb, count);
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            finder(left-1, res, sb, count-1);
            sb.deleteCharAt(sb.length()-1);
        }else return;
    }
}

// Refactor the first solution, elegant!
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        finder(0, 0, n, res, new String());
        return res;
    }
    
    public void finder(int l, int r, int n, ArrayList<String> res, String s){
        if (l > n || r > n || r > l)  return;           // r > l is important here
        if (l == n && r == n){
            res.add(s);
            return;
        }
        finder(l+1, r, n, res, s+"(");
        finder(l, r+1, n, res, s+")");
    }
}