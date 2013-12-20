// TLE in large judge
public class Solution {
    int depth;
    int minSum;
    int maxDepth;
    int sum;
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        if (triangle.get(0).size() == 0){
            return 0;
        }
        
        depth = 0;
        minSum = Integer.MAX_VALUE;
        maxDepth = triangle.size();
        DFS(triangle, triangle.get(0).get(0), 0);
        
        return minSum;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> triangle, int val, int index){
        sum += val;
        depth++;
        if (depth >= maxDepth){
            minSum = Math.min(minSum, sum);
        }
        else{
            DFS(triangle, triangle.get(depth).get(index), index);
            DFS(triangle, triangle.get(depth).get(index+1), index+1);
        }
        
        sum -= val;
        depth--;    
    }
}

// TLE in large judge
public class Solution {
    int minSum;
    int maxDepth;
    int sum;
    int min;
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        if (triangle.get(0).size() == 0){
            return 0;
        }
        sum = 0;
        minSum = Integer.MAX_VALUE;
        maxDepth = triangle.size();
        
        DFS(triangle, 0, 0, new HashMap<Integer, Integer>());
        
        return minSum;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> triangle, int depth, int index, HashMap<Integer, Integer> rowMin){
        int val = triangle.get(depth).get(index);

        if (depth == maxDepth -1){
            if (!rowMin.containsKey(depth)){
                rowMin.put(depth, val);
            }
            else{
                rowMin.put(depth, Math.min(rowMin.get(depth), val));
            }
        }
        else{
            if (rowMin.containsKey(depth+1)){
                 rowMin. val + Math.min(rowMin.);
            }
            DFS(triangle, depth + 1, index);
            DFS(triangle, depth + 1, index+1);
        }
        
           
    }
}

// DFS + DP, pass both judges
public class Solution {
    int minSum;
    int maxDepth;
    int sum;
    int min;
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        if (triangle.get(0).size() == 0){
            return 0;
        }
        sum = 0;
        minSum = Integer.MAX_VALUE;
        maxDepth = triangle.size();
        
        return DFS(triangle, 0, 0, new HashMap<Integer, Integer>());
    }
    
    public int DFS(ArrayList<ArrayList<Integer>> triangle, int depth, int index, HashMap<Integer, Integer> rowMin){
        int val = triangle.get(depth).get(index);
        int min = val;
        if (depth == maxDepth -1){
           return min;
        }
        else{
            if (rowMin.containsKey(depth+1)){
                min += Math.min(rowMin.get(depth+1), DFS(triangle, depth+1, index+1, rowMin));
            }
            else{
                min += Math.min(DFS(triangle, depth+1, index, rowMin), DFS(triangle, depth+1, index+1, rowMin));
            }            
        }
        
        rowMin.put(depth, min);
        return min;
    }
}


//# trial 3
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] path_sum = new int[triangle.size()+1];  // ATTENTION: array size is important here
        for (int level = triangle.size()-1; level >= 0; level--){
            ArrayList<Integer> curr_line = triangle.get(level);
            for (int j = 0; j< curr_line.size(); j++){
                path_sum[j] = curr_line.get(j) + Math.min(path_sum[j], path_sum[j+1]);
            }
        }
        return path_sum[0];
    }
}

