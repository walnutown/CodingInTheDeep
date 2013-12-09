public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start == null || end == null || start.length() == 0 || start.equals(end)){
            return 0;
        }
        
        Queue<String> qu = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Map<String, String> path = new HashMap<String, String>();
        int minStep = 0;
        visited.add(start);
        qu.add(start);
        
        
        while(qu.size() > 0){
            String prev = qu.poll();
            for (String curr : adjacent(prev, dict)){
                if (!visited.contains(curr)){
                    qu.add(curr);
                    visited.add(curr);
                    path.put(curr, prev);
                }
                if (curr.equals(end)){
                    int step = 0;
                    while (curr!= null){
                        curr = path.get(curr);
                        step++;
                    }
                    if (minStep == 0 || step < minStep){
                        minStep = step;
                    }            
                }
                
                
            }
        }
        
        return minStep;
        
    }
    
    public Set<String> adjacent(String prev, HashSet<String> dict){
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < prev.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                StringBuilder sb = new StringBuilder(prev);
                sb.setCharAt(i, c);
                String curr = sb.toString();
                if (dict.contains(curr) && !curr.equals(prev)){
                    res.add(curr);
                }
            }
        }
        
        return res;
    }
}