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


// from outer layer to inner layer, similar to RotateImage
// If the number of layers is odd, we'll have a central cell, remember to fill it;
// Otherwise, there's no central cell.
// In RotateImage, we didn't handle the central cell, why? Because no matter there's central
// cell or not, we don't have to rotate it.
// time: O(n); sapce: O(1)
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n<0)    return null;
        int[][] M = new int[n][n];
        int num = 1;
        for (int layer=0; layer<n/2; layer++){
            for (int i=layer; i<n-1-layer; i++)
                M[layer][i] = num++; 
            for (int i=layer; i<n-1-layer; i++)
                M[i][n-1-layer] = num++;
            for (int i=n-1-layer; i>layer; i--)
                M[n-1-layer][i] = num++;
            for (int i=n-1-layer; i>layer; i--)
                M[i][layer] = num++;
        }
        if ((n&1)!=0)
            M[n/2][n/2] = num;
        return M;
    }
}