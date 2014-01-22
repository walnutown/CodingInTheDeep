/*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    Each number in C may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
    A solution set is: 
    [1, 7] 
    [1, 2, 5] 
    [2, 6] 
    [1, 1, 6] 
*/

// DFS
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        finder(num, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int[] num, int index, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = index; i< num.length; i++){
            if (i > index && num[i] == num[i-1])    continue;       // compare with CombinationSum, only add one sentence here
            r.add(num[i]);
            finder(num, i+1, target-num[i], res, r);
            r.remove(r.size()-1);
        }
    }
}