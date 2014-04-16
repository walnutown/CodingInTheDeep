/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
*/

// points to remember in combination/permutation question
// 1) when to add res to resList
// 2) order of elements in the res, notice requirement for descending or non-descending
// 3) create new arrayList when add res to resList

// DFS
// time: O(Combination(n,k)), Combination(n,k) = (n!)/(k!*(n-k)!
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        finder(n, 0, k, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int n, int index, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (k==0){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = index+1; i <= n; i++){
            r.add(i);
            finder(n, i+1, k-1, res, r);
            r.remove(r.size()-1);
        }
    }
}
