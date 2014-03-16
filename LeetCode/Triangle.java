/*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

// We can use DFS to add sum from top to bottom
// time: O(2^h) (number of paths from root to leaf in binary tree), h is the height of the triangle; space: O(2^h)

// add from the bottom to top. This solution modifies the original triangle
// time: O(n); space: O(1)
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;
        for (int i=triangle.size()-2; i>=0; i--){
            ArrayList<Integer> curr = triangle.get(i), below = triangle.get(i+1);
            for (int j=0; j<curr.size(); j++)
                curr.set(j, Math.min(below.get(j), below.get(j+1))+curr.get(j));
        }
        return triangle.get(0).get(0);
    }
}

// add from the bottom to top, use additional array to store the sum of paths. 
// This solution doesn't modify the original triangle
// time: O(n); space: O(n)
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] S = new int[triangle.size()+1];  
        for (int level = triangle.size()-1; level >= 0; level--){
            ArrayList<Integer> curr = triangle.get(level);
            for (int j = 0; j< curr.size(); j++){
                S[j] = curr.get(j) + Math.min(S[j], S[j+1]);
            }
        }
        return S[0];
    }
}

