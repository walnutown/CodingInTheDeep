// TEL in large judge

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] newStrs = new String[strs.length];
        
        for (int i = 0; i < strs.length; i++){
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr);
            newStrs[i] = new String(charStr);
            if (!map.containsKey(newStrs[i])){
                map.put(newStrs[i], i);
            }
            else {
                if (int prev = map.get(newStrs[i]) >= 0){
                    res.add(strs[prev]);
                    map.put(newStrs[i], -1);
                }
                res.add(strs[i]);
            }
        }
        
        
        return res;
    }
}

// one pass, pass both, use map to store the first index of the anagrams
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] newStrs = new String[strs.length];
        
        for (int i = 0; i < strs.length; i++){
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr);
            newStrs[i] = new String(charStr);
            if (!map.containsKey(newStrs[i])){
                map.put(newStrs[i], i);
            }
            else {
                int prev = map.get(newStrs[i]);
                if (prev >= 0){
                    res.add(strs[prev]);
                    map.put(newStrs[i], -1);
                }
                res.add(strs[i]);
            }
        } 
        return res;
    }
}

