/*
    Given a set of distinct integers, S, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/

// A permutation is an ordered combination, order does matter in permutation.
// e.g. [1,1,2] and [1,2,1] is different
// while order does not matter in permutation
// e.g. [1,1,2] and [1,2,1] are the same

// DFS, time: O(n!)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S==null || S.length==0) return res;
        Arrays.sort(S);
        finder(0, S, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int index, int[] S, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (index == S.length)  return;
        for (int i=index; i<S.length; i++){
            r.add(S[i]);
            res.add(new ArrayList<Integer>(r));
            finder(i+1, S, res, r);
            r.remove(r.size()-1);
        }
    }
}

// create new set based on previous set, recursive version
// [[],[1]], 2 -> [[2],[1,2]]
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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

// create new set based on previous set, iterative version. time: O(n!)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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



