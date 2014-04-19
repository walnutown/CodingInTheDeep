/*
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


    OJ's undirected graph serialization:
    Nodes are labeled uniquely.

    We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    As an example, consider the serialized graph {0,1,2#1,2#2,2}.

    The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Basic idea is to use memoization to reduce duplicate computation and avoid cycles
// Maintain a map<oldNode, newNode>, if the oldNode is in the map, get newNode from the map directly;
// otherwise, create a new node

// DFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        if (node == null)   return null;
        if (map.containsKey(node))    return map.get(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node, res);
        if (node.neighbors == null || node.neighbors.size() == 0) return res;
        for (UndirectedGraphNode n : node.neighbors)
            res.neighbors.add(clone(n, map));
        return res;
    }
}

// BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        Queue<UndirectedGraphNode> qu = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        qu.add(node);
        while (!qu.isEmpty()){
            UndirectedGraphNode curr = qu.poll();
            if (!map.containsKey(curr))
                map.put(curr, new UndirectedGraphNode(curr.label));
            for (UndirectedGraphNode adj : curr.neighbors){
                if (!map.containsKey(adj)){
                    map.put(adj, new UndirectedGraphNode(adj.label));
                    qu.add(adj);
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return map.get(node);
    }
}