// A permutation is an ordered combination
// MLE in small judge
public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        resList.add(null);
        int len = S.length;
        if (S == null || len == 0){
            return resList;
        }
        
        for (int i = 1; i <= len; i++){
            int curr = S[i-1];
            for (int j = 0; j<resList.size(); j++){
                ArrayList<Integer> newRes; 
                if (resList.get(j) != null){
                    newRes = new ArrayList<Integer>(resList.get(j));
                }
                else{
                    newRes = new ArrayList<Integer>();
                }
                newRes.add(curr);
                resList.add(newRes);
            }
            
        }
        
        return resList;
    }
    
}

// DFS
public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        res = new ArrayList<Integer>();
        resList.add(new ArrayList<Integer>());
        int len = S.length;
        if (S == null || len == 0){
            return resList;
        }
        // element in ubset should be in non-descending order
        Arrays.sort(S);
        
        DFS(S, 0);
        return resList;
    }
    
    public void DFS(int[] S, int depth){
        for(int i = depth; i < S.length; i++){
            res.add(S[i]);
            resList.add(new ArrayList<Integer>(res));
            DFS(S, i+1);
            res.remove(res.size()-1);
        }
    }
    
}





