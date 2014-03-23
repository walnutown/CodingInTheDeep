/*
    Given an integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
*/

// iteration, similar to SpiralMatrix
// time: O(n); space: O(1)
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        if (n==0)   return new int[0][0];
        int left = 0, right=n-1, top=0, bottom=n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while (left <= right && top <= bottom){
            for (int i=left; i<=right; i++)  matrix[top][i] = num++;
            if (++top > bottom) break;
            for (int i=top; i<=bottom; i++)  matrix[i][right] = num++;
            if (--right < left) break;
            for (int i=right; i>=left; i--)  matrix[bottom][i] = num++;
            if (--bottom < top) break;
            for (int i=bottom; i>=top; i--)  matrix[i][left] = num++;
            if (++left > right) break;
        }
        return matrix;
    }
}