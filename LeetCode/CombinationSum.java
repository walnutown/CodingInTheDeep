/*
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7, 
    A solution set is: 
    [7] 
    [2, 2, 3] 
*/

// The same to the coin change problem: Given a set of coins, find all the ways to make a change

// DFS
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)   return res;
        Arrays.sort(candidates);
        finder(candidates, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int[] candidates, int index, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (target < 0)   return;
        if (target == 0){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            r.add(candidates[i]);
            finder(candidates, i, target - candidates[i], res, r);
            r.remove(r.size()-1);
        }
    }
}