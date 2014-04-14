/*
    Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
*/

// Get each level in top-down order
// Each level is based on the previous level
// time: O(n^2); sapce: O(n^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows <=0)    return res;
        ArrayList<Integer> prev = new ArrayList<Integer>(); prev.add(1);
        res.add(prev);
        for (int i=2; i<=numRows; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j=1; j<prev.size(); j++)   curr.add(prev.get(j-1) + prev.get(j));
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}