// can only record one path
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (start == null || end == null || start.length() == 0 || start.equals(end)){
            return res;
        }
        
        Map<String, String> path = new HashMap<String, String>();
        Set<String> visited = new HashSet<String>();
        Queue<String> qu = new LinkedList<String>();
        int minStep = 0;
        qu.add(start);
        visited.add(start);
        while (qu.size() > 0){
            String prev = qu.poll();
            for (String curr : adjacent(prev, dict)){
                if (!visited.contains(curr)){
                    visited.add(curr);
                    qu.add(curr);
                    path.put(curr,prev);
                }
                if (curr.equals(end)){
                    ArrayList<String> pathList = new ArrayList<String>();
                    while(curr != null){
                        pathList.add(0, curr);
                        curr = path.get(curr);
                    }
                    
                    if (pathList.size() < minStep || minStep == 0){
                        minStep = pathList.size();
                        res.clear();
                        res.add(pathList);     
                    }
                    else if (pathList.size() == minStep){
                        if (!res.contains(pathList)){
                            res.add(pathList);  
                        }
                    }      
                }
            }     
        }
        
        return res;
        
    }
    
    public Set<String> adjacent(String prev, HashSet<String> dict){
        Set<String> res = new HashSet<String>();
        for (int i=0; i < prev.length(); i++){
            StringBuilder sb = new StringBuilder(prev);
            for (char c = 'a'; c <= 'z'; c++){
                sb.setCharAt(i, c);
                String s = sb.toString();
                if (dict.contains(s) && !s.equals(prev)){
                    res.add(s);
                }
            }
        }
        return res;
    }
}