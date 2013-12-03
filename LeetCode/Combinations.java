// points to remember in combination/permutation question
// 1) when to add res to resList
// 2) order of elements in the res
// 3) create new arrayList when add res to resList
public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        res = new ArrayList<Integer>();
        if (k > n){
            return resList;
        }     
        DFS(n, 1, 1, k);
        return resList; 
    }
    
    public void DFS(int num, int index, int depth, int maxDepth){
        if (depth > maxDepth){
            return;
        }
        
        for(int i = index; i <= num; i++){
            res.add(i);
            if (depth == maxDepth){
                ArrayList<Integer> temp = new ArrayList<Integer>(res);
                Collections.sort(temp);
                resList.add(temp);
            }
            DFS(num, i+1, depth + 1, maxDepth);
            res.remove(res.size()-1);
        }
    }
}



// trial #2
// Submission Result: Runtime Error
// Last executed input:    1, 1

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        // assert k <= n
        if (k == 0 || n == 0)
            return res;
        getCombinations(res, k, n, 1, new ArrayList<Integer>());
        return res;
    }
    
    public void getCombinations(ArrayList<ArrayList<Integer>> res, int k, int n, int dep, ArrayList<Integer> r){
        if (dep == k+1){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = dep; i <= n-k+1; i++){
            r.add(i);
            getCombinations(res, k, n, dep+1, r);
            r.remove(i);
        }
    }
}


// memory limit exceeded
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        // assert k <= n
        if (k == 0 || n == 0)
            return res;
        getCombinations(res, k, n, 1, new ArrayList<Integer>());
        return res;
    }
    
    public void getCombinations(ArrayList<ArrayList<Integer>> res, int k, int n, int dep, ArrayList<Integer> r){
        if (dep == k+1){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = dep; i <= n; i++){
            r.add(i);
            getCombinations(res, k, n, dep+1, r);
            r.remove(r.size()-1);
        }
    }
}

