/*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
*/

// Rotate the matrix by layers, from outer layer to inner layer
// Each time, we swap the four borders in a layer in clockwise direction
// time: O(n); space: O(1)
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        int N = matrix.length;
        for (int layer=0; layer<N/2; layer++){
            for (int i=layer; i<= N-2-layer; i++){
                int tmp = matrix[layer][i]; // cache left border
                matrix[layer][i] = matrix[N-1-i][layer];
                matrix[N-1-i][layer] = matrix[N-1-layer][N-1-i];
                matrix[N-1-layer][N-1-i] = matrix[i][N-1-layer];
                matrix[i][N-1-layer] = tmp;
            }
        }
    }
}