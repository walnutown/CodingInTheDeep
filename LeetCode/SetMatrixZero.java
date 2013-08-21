// use first row and col to store status of matrix
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        if (matrix.length > 1 && matrix[0].length > 1){
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[i].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        }
        
        if (isFirstRowZero){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        
        if (isFirstColZero){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}