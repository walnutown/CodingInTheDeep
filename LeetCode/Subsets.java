// A permutation is an ordered combination
// order does matter in permutation
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

// Output Limit Exceed, Dec 25, recursion
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0)     return res;
        return finder(S, S.length-1);
    }
    
    public ArrayList<ArrayList<Integer>> finder(int[] S, int index){
        if (index < 0){
             ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
             res.add(new ArrayList<Integer>());
             return res;
        }
        ArrayList<ArrayList<Integer>> old_sets = finder(S, index-1);
        ArrayList<ArrayList<Integer>> new_sets = new ArrayList<ArrayList<Integer>>(old_sets);
        for (ArrayList<Integer> r : new_sets)
            r.add(S[index]);
        new_sets.addAll(old_sets);
        return new_sets;
    }
}
// runtime error
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // a set of distinct integers
        // Elements in a subset must be in non-descending order
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0)     return res;
        Arrays.sort(S);
        return finder(S, S.length-1);
    }
    
    public ArrayList<ArrayList<Integer>> finder(int[] S, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (index < 0){
             res.add(new ArrayList<Integer>());
             return res;
        }
        res = finder(S, index-1);
        for (ArrayList<Integer> r : res){           // concurrent modificaiotn exception, res keeps changing 
            ArrayList<Integer> new_set = new ArrayList<Integer>(r);
            new_set.add(S[index]);
            res.add(new_set);
        }
        return res;
    }
}
// Accepted
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // a set of distinct integers
        // Elements in a subset must be in non-descending order
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0)     return res;
        Arrays.sort(S);
        return finder(S, S.length-1);
    }
    
    public ArrayList<ArrayList<Integer>> finder(int[] S, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (index < 0){
             res.add(new ArrayList<Integer>());
             return res;
        }
        res = finder(S, index-1);
        ArrayList<ArrayList<Integer>> new_subsets = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> r : res) {
            ArrayList<Integer> new_set = new ArrayList<Integer>(r);
            new_set.add(S[index]);
            new_subsets.add(new_set);
        }
        res.addAll(new_subsets);
        return res;
    }
}


// DP, the best solution to the subset problem
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // a set of distinct integers
        // Elements in a subset must be in non-descending order
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0)     return res;
        Arrays.sort(S);
        for (int i=0; i<S.length; i++){
            int size = res.size();
            for (int j=0; j<size; j++){
                ArrayList<Integer> new_set = new ArrayList<Integer>(res.get(j));
                new_set.add(S[i]);
                res.add(new_set);
            }
        }
        return res;
    }
}



