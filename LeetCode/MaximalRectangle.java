/*
    Given a 2D binary matrix filled with 0's and 1's, 
    find the largest rectangle containing all ones and return its area.
*/

// Based on Leetcode/LargestRectangleInHistogram
// [1] Maintain an array holding the heights of a row.
// [2] Calculate the largest rectangle in the area above the current row
// [3] Extend the area gradually until we reach the last row
// time: O(m*n); space: O(n)
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length, n=matrix[0].length;
        int[] h = new int[n];
        int max = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) h[j] = matrix[i][j]=='0' ? 0:h[j]+1;
            max = Math.max(max, finder(h));
        }
        return max;
    }
    public int finder(int[] h){
        Stack<Integer> left = new Stack<Integer>();
        int r=0, max=0;
        while (r<h.length){
            if (left.isEmpty() || h[r]>=h[left.peek()])    left.push(r++);
            else{
                int height = h[left.pop()];
                int len = left.isEmpty() ? r:r-left.peek()-1;
                max = Math.max(max, height*len);
            }
        }
        while (!left.isEmpty()){
            int height = h[left.pop()];
            int len = left.isEmpty() ? r:r-left.peek()-1;
            max = Math.max(max, height*len);
        }
        return max;
    }
}