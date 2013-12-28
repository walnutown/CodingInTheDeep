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

// use array to store the mapping
public class Solution {
    ArrayList<String> res; 
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<String>();
        if (digits == null || digits.length() == 0){
            res.add("");
            return res;
        }
        String[] dict = new String[10];
        dict[0] = " ";
        dict[1] = "";
        dict[2] = "abc";
        dict[3] = "def";
        dict[4] = "ghi";
        dict[5] = "jkl";
        dict[6] = "mno";
        dict[7] = "pqrs";
        dict[8] = "tuv";
        dict[9] = "wxyz";
        DFS(0, "", digits, dict);
        return res;
    }
    
    public void DFS(int dep, String str, String digits, String[] dict){
        if (dep == digits.length()){
            res.add(str);
            return;
        }
        int curr = digits.charAt(dep) - '0';
        for (int i = 0; i < dict[curr].length(); i++){
            DFS(dep+1, str+ dict[curr].charAt(i), digits, dict);
        }
    }
}


// Submission Result: Runtime Error

// Last executed input:    "2"
public class Solution {
    ArrayList<String> res; 
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0)   return res;
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, " ");
        finder(digits, 0, res, new StringBuilder(), map);
        return res;
    }
    
    public void finder(String digits, int index, ArrayList<String> res, StringBuilder sb, Map<Integer, String> map){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        String sets = map.get(digits.charAt(index));        // error here
        for (int i=0; i < sets.length(); i++){
            char ch = sets.charAt(i);
            sb.append(ch);
            finder(digits, index+1, res, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
// Accepted
public class Solution {
    ArrayList<String> res; 
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0){   
            res.add("");
            return res;
        }
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, " ");
        finder(digits, 0, res, new StringBuilder(), map);
        return res;
    }
    
    public void finder(String digits, int index, ArrayList<String> res, StringBuilder sb, Map<Integer, String> map){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        String sets = map.get(digits.charAt(index) - '0');
        for (int i=0; i < sets.length(); i++){
            char ch = sets.charAt(i);
            sb.append(ch);
            finder(digits, index+1, res, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}