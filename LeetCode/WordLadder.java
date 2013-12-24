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



// TLE, Dec 23, DFS
public class Solution {
    private int min;
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // DFS with visited set
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        min = 0;
        finder(start, end, dict, visited, 1);
        return min;
    }
    
    public void finder(String start, String end, HashSet<String> dict, Set<String> visited, int cost){
        if (start.equals(end)){
            min = Math.min(min, cost);
            return;
        }
        Set<String> adjacents = getAdjacents(start, dict);
        for (String adj : adjacents){
            if (visited.contains(adj))  continue;
            visited.add(adj);
            finder(adj, end, dict, visited, cost+1);
            visited.remove(adj);
        }
    }
    
    public Set<String> getAdjacents(String start, HashSet<String> dict){
        Set<String> adjacents = new HashSet<String>();
        StringBuilder sb = new StringBuilder(start);
        for (int i = 0; i < start.length(); i++){
            char curr = start.charAt(i);
            for (char j = 'a'; j <= 'z'; j++){
                if (curr == j)  continue;
                sb.setCharAt(i, j);
                String adj = sb.toString();
                if (dict.contains(adj))
                    adjacents.add(adj);
            }
        }
        return adjacents;
    }   
}

// BFS, TLE
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // BFS with visited set
        Set<String> visited = new HashSet<String>();
        int cost = 1;
        int curr_num = 1, next_num = 0;
        Queue<String> qu = new LinkedList<String>();
        qu.add(start);
        while (!qu.isEmpty()){
            String curr = qu.poll();
            visited.add(curr);
            for (int i = 0; i < start.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(i, j);
                    String adj = sb.toString();
                    if (adj.equals(end))    return cost + 1;
                    if (dict.contains(adj) && !visited.contains(adj)){
                        qu.add(adj);
                        next_num++;
                    }
                }
            }
            curr_num--;
            if (curr_num == 0){
                curr_num = next_num;
                next_num = 0;
                cost++;
            }
        }
        return 0;
    }
}

// BFS, Accepted, Dec 23
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // BFS with visited set
        Set<String> visited = new HashSet<String>();
        int cost = 1;
        int curr_num = 1, next_num = 0;
        Queue<String> qu = new LinkedList<String>();
        qu.add(start);
        visited.add(start);
        while (!qu.isEmpty()){
            String curr = qu.poll();
            for (int i = 0; i < start.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(i, j);
                    String adj = sb.toString();
                    if (adj.equals(end))    return cost + 1;
                    if (dict.contains(adj) && !visited.contains(adj)){
                        qu.add(adj);        
                        visited.add(adj);   // just move visited.add() here, and pass the case
                        next_num++;         // can avoid more duplicates, because size of visited increases faster than the above
                    }
                }
            }
            curr_num--;
            if (curr_num == 0){
                curr_num = next_num;
                next_num = 0;
                cost++;
            }
        }
        return 0;
    }
}