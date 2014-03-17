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
        int count = 2;
        ArrayList<String> prev = new ArrayList<String>();
        prev.add(start);
        while (!prev.isEmpty()){
            ArrayList<String> curr = new ArrayList<String>();
            for (String w : prev){
                for (int i=0; i<w.length(); i++){
                    StringBuilder sb = new StringBuilder(w);
                    for (char j='a'; j<='z'; j++){
                        sb.setCharAt(i, j);
                        String adj = sb.toString();
                        if (end.equals(adj))
                            return count;
                        if (dict.contains(adj)){
                            curr.add(adj);
                            dict.remove(adj);
                        }
                    }
                }
            }
            count++;
            prev = curr;
        }
        return 0;
    }
        
}