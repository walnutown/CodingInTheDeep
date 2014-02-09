/*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
*/

// BFS, time: O(n); space: O(b^d)
// shortest path problem. When the edge cost is 1 unit, uniform cost search is equal to BFS
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
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
                        visited.add(adj);   // add 'visited.add()' here, instead of below  'String curr = qu.poll()'
                        next_num++;         // can avoid more duplicates, because size of visited increases faster 
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

// modified version, no need of visited set.
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int cost = 1;
        int curr_num = 1, next_num = 0;
        Queue<String> qu = new LinkedList<String>();
        qu.add(start);
        dict.remove(start);
        while (!qu.isEmpty()){
            String curr = qu.poll();
            for (int i = 0; i < start.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(i, j);
                    String adj = sb.toString();
                    if (adj.equals(end))    return cost + 1;
                    if (dict.contains(adj)){
                        qu.add(adj);        
                        dict.remove(adj);   
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