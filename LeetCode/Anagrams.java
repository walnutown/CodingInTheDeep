/*
    Given an array of strings, return all groups of strings that are anagrams.

    Note: All inputs will be in lower-case.
*/

// Instead of sorted string, we can also use other key in map, such as string compression, aabc -> a2b1c1
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) return res;
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs){
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sorted_str = String.valueOf(ch_arr);
            if (map.containsKey(sorted_str))   map.get(sorted_str).add(str);
            else{
                ArrayList<String> r = new ArrayList<String>();
                r.add(str);
                map.put(sorted_str, r);
            }
        }
        for (ArrayList<String> r : map.values())
            if (r.size() > 1)   res.addAll(r);
        return res;
    }
}

