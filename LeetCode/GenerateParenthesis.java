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