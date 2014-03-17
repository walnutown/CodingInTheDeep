/*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    Return
      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
*/
// similar to print the shortest path between two nodes on a graph
// BFS + map(store previous ndoes)
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
      Map<String, Set<String>> map = new HashMap<String, Set<String>>();
      ArrayList<Set<String>> layers = new ArrayList<Set<String>>();
      layers.add(new HashSet<String>());
      layers.add(new HashSet<String>());
      int curr = 0, next = 1;
      dict.add(start);
      ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
      layers.get(curr).add(end);// start from end, so that no need to reverse the path when
                                // buildPaths
      while (true) {
         for (String w : layers.get(curr))
            dict.remove(w);
         Iterator<String> it = layers.get(curr).iterator();
         while (it.hasNext()) {
            String word = it.next();
            for (int i = 0; i < word.length(); i++) {
               for (char j = 'a'; j <= 'z'; j++) {
                  StringBuilder sb = new StringBuilder(word);
                  sb.setCharAt(i, j);
                  if (sb.equals(word))
                     continue;
                  String adj = sb.toString();
                  if (dict.contains(adj)) {
                     layers.get(next).add(adj);
                     if (map.containsKey(adj))
                        map.get(adj).add(word);
                     else {
                        map.put(adj, new HashSet<String>());
                        map.get(adj).add(word);
                     }
                  }
               }
            }
         }
         if (layers.get(next).isEmpty() || layers.get(next).contains(start))
            break;
         int tmp = curr;
         curr = next;
         next = tmp;
         layers.get(next).clear();
      }
      if (!map.isEmpty()){
         ArrayList<String> path = new ArrayList<String>();
         path.add(start);
         buildPaths(start, end, map, paths, path);
      }
      return paths;
   }

   public void buildPaths(String curr, String end, Map<String, Set<String>> map, ArrayList<ArrayList<String>> paths, ArrayList<String> path) {
      if (curr.equals(end)) {
         paths.add(new ArrayList<String>(path));
         return;
      }
      for (String w : map.get(curr)) {
         path.add(w);
         buildPaths(w, end, map, paths, path);
         path.remove(path.size() - 1);
      }  
   }
}

// TLE, but this version's structure is more similar to WordLadder
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
      Map<String, Set<String>> map = new HashMap<String, Set<String>>();
      ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
      ArrayList<String> prev = new ArrayList<String>();
      prev.add(end);
      dict.remove(end);
        boolean done = false;
      while (!prev.isEmpty() && !done) {
         ArrayList<String> curr = new ArrayList<String>();
         for (int k=0; k<prev.size(); k++) {
            String word = prev.get(k);
            for (int i = 0; i < word.length(); i++) {
               for (char j = 'a'; j <= 'z'; j++) {
                  StringBuilder sb = new StringBuilder(word);
                  sb.setCharAt(i, j);
                  String adj = sb.toString();
                  if (start.equals(adj))
                    done = true;
                  if (word.equals(adj))
                     continue;
                  if (dict.contains(adj)) {
                     curr.add(adj);
                     if (map.containsKey(adj))
                        map.get(adj).add(word);
                     else {
                        map.put(adj, new HashSet<String>());
                        map.get(adj).add(word);
                     }
                  }
               }
            }
         }
         for (String s : curr) // move the visited words
            dict.remove(s);
         prev = curr;
      }
      if (!map.isEmpty()){
         ArrayList<String> path = new ArrayList<String>();
         path.add(start);
         buildPaths(start, end, map, paths, path);
      }
      return paths;
   }

   public void buildPaths(String curr, String end, Map<String, Set<String>> map, ArrayList<ArrayList<String>> paths, ArrayList<String> path) {
      if (curr.equals(end)) {
         paths.add(new ArrayList<String>(path));
         return;
      }
      for (String w : map.get(curr)) {
         path.add(w);
         buildPaths(w, end, map, paths, path);
         path.remove(path.size() - 1);
      }  
   }
}


