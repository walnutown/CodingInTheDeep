// TLE. not work if T has duplicate chars
public class Solution {
    ArrayList<Integer> pos;
    int minWidth;
    String minStr;
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.length() < T.length()){
            return "";
        }
        
        Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < S.length(); i++){
            char curr = S.charAt(i);
            if (!map.containsKey(curr)){
                ArrayList<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                map.put(curr, pos);
            }
            else{
                ArrayList<Integer> pos = map.get(curr);
                pos.add(i);
                map.put(curr, pos);
            }
        }
        pos = new ArrayList<Integer>();
        minStr = "";
        minWidth = Integer.MAX_VALUE;
        DFS(0, S, T, map);
        return minStr;
    }
    
    public void DFS(int dep, String S, String T, Map<Character, ArrayList<Integer>> map){
        if (dep == T.length()){
            ArrayList<Integer> al = new ArrayList<Integer>(pos);
            Collections.sort(al);
            int width = al.get(al.size()-1) - al.get(0);
            if ( width< minWidth){
                minWidth = width;
                minStr = S.substring(al.get(0), al.get(al.size()-1)+1);
            }
            return;
        }
        char curr = T.charAt(dep);
        if (!map.containsKey(curr)){
            minWidth = 0;
            minStr = "";
            return;
        }
        ArrayList<Integer> p = map.get(curr);
        for (int i = 0 ; i< p.size(); i++){
            pos.add(p.get(i));
            DFS(dep+1, S, T, map);
            pos.remove(pos.size()-1);
        }
        
    }
}



//  http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
//  The second solution uses a sliding window, is good. 
public class Solution {
       
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.length() < T.length()){
            return "";
        }
        
        Map<Character, Integer> hasFind = new HashMap<Character, Integer>();
        Map<Character, Integer> tm = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++){
            char curr = T.charAt(i);
            if (tm.containsKey(curr)){
                tm.put(curr, tm.get(curr) + 1);
            }
            else
                tm.put(curr, 1);
        }
        int minWidth = Integer.MAX_VALUE;
        String minStr = "";
        int start = 0, end =0;
        int count = 0;
        for (; end < S.length(); end++){
            char curr = S.charAt(end);
            if (!tm.containsKey(curr))
                continue;
                
            if (!hasFind.containsKey(curr)){
                hasFind.put(curr, 1);
                count++;
            }
            else{
                hasFind.put(curr, hasFind.get(curr) + 1);
                if (hasFind.get(curr) <= tm.get(curr))
                    count++;
            }
        
            if (count == T.length()){
                char startCh = S.charAt(start);
                while (!tm.containsKey(startCh) || hasFind.get(startCh) > tm.get(startCh)){
                    if (!tm.containsKey(startCh))
                        start++;
                    else{
                        hasFind.put(startCh, hasFind.get(startCh) -1);
                        start++;
                    }
                    startCh = S.charAt(start);
                }
                int width = end - start + 1;
                if (width < minWidth){
                    minWidth = width;
                    minStr = S.substring(start, end+1);
                }
            }
        }
        
        return minStr;
    }
}