package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class IsBipartiteGraph {
   /**
    * Given a bipartite graph, check whether it's a bipartite or not.
    * (Divide the graph into two sets, so that there's no edge that connects vertices of same set)
    */
   // If there exists a cycle of odd length, it's not a bipartite graph
   // http://www.geeksforgeeks.org/bipartite-graph/
   
   

   // Sol1
   // Backtrack to check whether the graph is 2-colorable
   

   // Sol2
   // BFS
   // Color the start node as color 1, then its neighbors -1, then neighbor's neighbors 1
   // If we find a neighbor of same color, then it's not bipartite
   // In the following implementation, the graph is strongly connected. If the graph
   // is weakly connected (has several components). We have start BFS from different nodes
   // to ensure all the ndoes are colored.
   // time: O(n) 
   public boolean isBipartite(int[][] graph) {
      int N = graph.length;
      int[] colors = new int[N];
      ArrayList<Integer> prev = new ArrayList<Integer>();
      prev.add(0);
      colors[0] = 1;
      while (!prev.isEmpty()){
         ArrayList<Integer> curr = new ArrayList<Integer>();
         for (int node : prev){
            Set<Integer> adjs = getNeighbors(graph, node);
            for (int adj : adjs){
               if (colors[adj]==colors[node])
                  return false;
               if (colors[adj]!=0)
                  continue;
               colors[adj] = getOppositeColor(colors[node]);
               curr.add(adj);
            }
         }
         prev = curr;
      }
      return true;
   }

   private int getOppositeColor(int color){
      return 0-color;
   }
   
   private Set<Integer> getNeighbors(int[][] graph, int node){
      Set<Integer> adjs = new HashSet<Integer>();
      for (int i=0; i<graph.length; i++){
         if (graph[node][i]==1)
            adjs.add(i);
      }
      return adjs;
   }  
   
   @Test
   public void test(){
      int[][] graph = new int[][]{
            {0,1,1,0},
            {1,0,0,1},
            {1,0,0,0},
            {0,1,0,0},
      };
      System.out.println(isBipartite(graph));
   }

}
