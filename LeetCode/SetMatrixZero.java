/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

// Check first whether the first row and first column should be set to zeros
// then use first row and col as extra storage
// time: O(m*n); space: O(1)
public class Solution {
    public void setZeroes(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for (int i = 0; i < w; i++){
            if (matrix[0][i] == 0)  isFirstRowZero = true;
        }
        for (int i = 0; i < h; i++){
            if (matrix[i][0] == 0)  isFirstColZero = true;
        }
        for (int i = 1; i < h; i++){
            for (int j = 1; j < w; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < h; i++){        // Note these 2 for loops can quickly set zeros
            for (int j = 1; j < w; j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowZero){
            for (int i = 0 ; i < w; i++)
                matrix[0][i] = 0;
        }
        if (isFirstColZero){
            for (int i = 0 ; i < h; i++)
                matrix[i][0] = 0;
        }
    }
}

// use bit vector, max size of matrix should be no bigger than 64
// time: O(m*n); space:O(1)
// Note: this solution cannot pass OJ
public class Solution {
    public void setZeroes(int[][] matrix) {
        long row = 0;
        long col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                   row |= (1<< i);
                   col |= (1<< j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((row & (1<<i)) != 0 || (col & (1<<j)) != 0) {
                   matrix[i][j] = 0;
                }
            }
        }  
    }
}