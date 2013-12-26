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

// Accepted, Dec 24
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        finder(n, k, 0, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int n, int k, int index, int dep, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (dep == k){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = index+1; i <= n; i++){
            r.add(i);
            finder(n, k, i, dep+1, res, r);
            r.remove(r.size()-1);
        }
    }
}
