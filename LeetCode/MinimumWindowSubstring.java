// TLE
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