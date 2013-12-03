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

// DFS
// Time Limit 
public class Solution {
    private int min;
    public int ladderLength(String start, String end, HashSet<String> dict) {
        min = Integer.MAX_VALUE;
        Set<String> used = new HashSet<String>();
        used.add(start);
        getMinLength(start, end, dict, used, 1);
        return min;
    }
    
    public void getMinLength(String curr, String end, Set<String> dict, Set<String> used, int len){
        Set<String> nexts = getNexts(used, dict, curr);
        if (nexts.contains(end)){
            min = Math.min(len, min);
            return;
        }
        if (nexts.isEmpty())
            return;
        for (String next : nexts){
            used.add(next);
            getMinLength(next, end, dict, used, len+1);
            used.remove(used.size()-1);
        }
    }
    
    public Set<String> getNexts(Set<String> used, Set<String> dict, String curr){
        Set<String> nexts = new HashSet<String>();
        for (int i = 0; i < curr.length(); i++){
            StringBuilder next = new StringBuilder(curr);
            for (char c = 'a'; c <= 'z'; c++){
                next.setCharAt(i, c);
                String next_word = next.toString();
                if (dict.contains(next_word) && !used.contains(next_word) && !curr.equals(next_word))
                    nexts.add(next_word);
            }
        }
        return nexts;
    }
}
