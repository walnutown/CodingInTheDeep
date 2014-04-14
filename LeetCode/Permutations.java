/*
    Given a collection of numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// Note: no duplicates

// A permutation is an ordered combination, order does matter in permutation.
// e.g. [1,1,2] and [1,2,1] is different
// while order does not matter in combination
// e.g. [1,1,2] and [1,2,1] are the same

// DFS
// From the definition of permutation, in each position, we can have all the different values
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

// Iteration, put the same element at different positions
// time: O(n*n!), ArrayList.add() may take worst case O(n)
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length==0)
            return res;
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(num[0]);
        res.add(r);
        for (int i=1; i<num.length; i++){
            res = insert(res, num[i]);
        }
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> lists, int val){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> p : lists){
            for (int i=0; i<=p.size(); i++){    // notice i<=p.size() here
                ArrayList<Integer> r = new ArrayList<Integer>(p);
                r.add(i, val);
                res.add(r);
            }
        }
        return res;
    }
}


// Use in-place swap. The benefit is in the search step, there's no need to check whether the current value
// has been used or not, because the array has been modified, all the used values are before index
public class Solution {
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    private void permute(int[] num, int index, ArrayList<ArrayList<Integer>> permutations) {
        if(index == num.length - 1) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            for(int i : num) ret.add(i);
            permutations.add(ret);
            return;
        }
        for(int i = index; i < num.length; i++) {
            swap(num, index, i);
            permute(num, index + 1, permutations);
            swap(num, index, i);
        }
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, permutations);
        return permutations;
    }
}

