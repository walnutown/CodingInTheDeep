public class Solution {
    Map<Character, String> map; 
    ArrayList<String> res;
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        res = new ArrayList<String>();
        map = new HashMap<Character, String>();
        map.put('0', " ");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        if (digits.isEmpty()){
            res.add("");
            return res;
        }
        
        DFS(digits, 0, "");
        
        return res;
    }
    
    public void DFS(String digits, int depth, String str){
        if (depth == digits.length()){
            res.add(str);
            return;
        }
        
        String val = map.get(digits.charAt(depth));
        for (int i = 0; i < val.length(); i++){
            DFS(digits, depth+1, str + val.charAt(i));
        }
    }
}