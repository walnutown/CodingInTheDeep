// Submission Result: Wrong Answer
// Input:  {0,0,0}
// Output: {0,0,0#0,0,0#0,0,0}
// Expected:   {0,0,0}
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashSet<Integer>());
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node, Set<Integer> set){
        if (node == null)   return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);      // duplicate node here, if exist, just use the existing one
        if (node.neighbors == null || node.neighbors.size() == 0 || set.contains(node.label)) return res;
        set.add(node.label);
        for (UndirectedGraphNode n : node.neighbors){
            res.neighbors.add(clone(n, set));
        }
        return res;
    }
}



// Accepted, DFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<Integer, UndirectedGraphNode>());
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if (node == null)   return null;
        if (map.containsKey(node.label))    return map.get(node.label);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node.label, res);
        if (node.neighbors == null || node.neighbors.size() == 0) return res;
        for (UndirectedGraphNode n : node.neighbors){
            res.neighbors.add(clone(n, map));
        }
        return res;
    }
}