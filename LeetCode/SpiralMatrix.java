/*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    For example,
    Given the following matrix:

    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    You should return [1,2,3,6,9,8,7,4,5].
*/

// Iterative, update the four borders of the matrix.
// time: O(n); space:(1)
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length==0 || matrix[0].length==0)  return res;
        int left=0, right=matrix[0].length-1, top=0, bottom= matrix.length-1;
        while (left <= right && top <=bottom){
            for (int i=left; i<=right; i++)  
                res.add(matrix[top][i]);
            if (++top > bottom) break;          // need to break immediately, otherwise will influence the value of 'right' and 'left'
            for (int i=top; i<=bottom; i++) 
                res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i=right; i>=left; i--)    
                res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i=bottom; i>=top; i--)   
                res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}