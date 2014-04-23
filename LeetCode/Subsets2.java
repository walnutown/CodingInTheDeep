/*
    Given a collection of integers that might contain duplicates, S, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/

// DFS
// time: O(n!); space: O(n!)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
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
            if (i>index && S[i]==S[i-1]) continue;  //'i>index' is IMPORTANT, to make sure that the first occurance of a number should be added into the set.
            r.add(S[i]);
            res.add(new ArrayList<Integer>(r));
            finder(i+1, S, res, r);
            r.remove(r.size()-1);
        }
    }
}

// Iteratively add new element to all the existing subsets.
// If the newly-added element is equal to the previously-added element, we only add this
// new element to a part of the exisitng subsets to avoid duplicates
// time: O(2^n), each time, the number of subsets is multiplied by 2 (in average)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length==0)
            return res;
        Arrays.sort(num);
        res.add(new ArrayList<Integer>());
        int N = num.length, start = 0;
        for (int i=0; i<N; i++){
            int size = res.size();
            for (int j=start; j<size; j++){
                ArrayList<Integer> r =  new ArrayList<Integer>(res.get(j));
                r.add(num[i]);
                res.add(r);
            }
            start = (i<N-1 && num[i]==num[i+1])? size:0;
        }
        return res;
    }
}