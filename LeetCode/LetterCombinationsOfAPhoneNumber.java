/*
    Given a digit string, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below
    
    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

// Backtracking
// time: O(n*m), n is the number of digits, m is the average size of digit's mapping letters
public class Solution {
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
    
    private void finder(String digits, int index, ArrayList<String> res, StringBuilder sb, Map<Integer, String> map){
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

// BFS
public ArrayList<String> letterCombinations2(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits == null) return result;
        LinkedList<StringBuilder> queue = new LinkedList<StringBuilder>();
        // initial
        queue.add(new StringBuilder());
        // bfs
        for(int i = 0; i < digits.length(); i++) {
            LinkedList<StringBuilder> tmp = new LinkedList<StringBuilder>();
            // for every path so far
            for(StringBuilder sb : queue) {
                // for every possibile letters
                for(char letter : getLetters(digits.charAt(i))) {
                    StringBuilder nsb = new StringBuilder(sb);
                    nsb.append(letter);
                    tmp.add(nsb);
                }
            }
            queue = tmp;
        }
        // result
        for(StringBuilder sb : queue) {
            result.add(sb.toString());
        }
        return result;
    }
