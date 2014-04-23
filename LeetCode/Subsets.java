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

// DFS
// time: O(n!); sapce: recursive stack
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

// Create new subsets baseed on previous subsets.
// Assume we've got all the subsets compsed of S[0...i-1], we can get all the subsets containing S[i-1]
// by adding S[i-1] to each previous subsets.
// eg, [[]]->[[],[1]] -> [[],[1],[2],[1,2]]...
// time: O(1+2+4+...+2^n) = O(2^n); sapce: O(1)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S==null || S.length==0)     return res;
        Arrays.sort(S);
        int N = S.length;
        res.add(new ArrayList<Integer>());
        for(int i=0; i<N; i++){
            for (int j=res.size()-1; j>=0; j--){
                ArrayList<Integer> r = new ArrayList<Integer>(res.get(j));
                r.add(S[i]);
                res.add(r);
            }
        }
        return res;
    }
}

// bit manipulation, each subset can be represented as a binary string
// if i-th bit of the binary string is 1, then S[i] appears in the subset
// this solution is limited by the architecture of the OS
// e.g. the max size of the given set is 64 if the OS is 64bit
// time: O(2^n * n), space: O(1)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        int N = (1<<S.length);  // total number of susets is 2^length -1
        for (int i=0; i<N; i++)
            finder(i, res, S);
        return res;
    }
    
    private void finder(int num, ArrayList<ArrayList<Integer>> res, int[] S){
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (int i=0; i<S.length; i++){
            if ( ((1<<i)&num)>0 )
                r.add(S[i]);
        }
        res.add(r);
    }
}



