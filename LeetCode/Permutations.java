/*
    Given a collection of numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// DFS, skip visited numbers
// time: O(n!)
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        finder(num, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int[] num, int dep, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (dep == num.length){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (r.contains(num[i])) continue;
            r.add(num[i]);
            finder(num, dep+1, res, r);
            r.remove(r.size()-1);
        }
    }
}

