public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        while( i < matrix.length){
            if (matrix[i][matrix[i].length-1] == target){
                return true;
            }
            else if (matrix[i][matrix[i].length-1] > target ){
                for (int j = 0; j < matrix[i].length -1; j++){
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
                return false;
            }
            else{
                i++;
            }
        }
        return false;
    }
}