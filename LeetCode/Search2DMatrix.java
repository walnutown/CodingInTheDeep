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

// Accepted, Dec 26, only bianry search in row
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length;
        int h = matrix.length;
        for (int i = 0; i < h; i++){
            if (target > matrix[i][w-1])    continue;
            int start=0, end=w-1;
            while (start <= end){
                int mid = (start + end) >> 1;
                if (matrix[i][mid] == target)   return true;
                else if (matrix[i][mid] > target)   end=mid-1;
                else    start=mid+1;
            }
        }
        return false;
    }
}
// Accepted, binary search both col and row
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length;
        int h = matrix.length;
        int start=0, end=h-1, row = 0;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (matrix[mid][w-1] < target)  start=mid+1;
            else if (matrix[mid][0] > target)   end=mid-1;
            else{
                row = mid;
                break;
            }
        }
        start=0;
        end=w-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (matrix[row][mid] == target)   return true;
            else if (matrix[row][mid] > target)   end=mid-1;
            else    start=mid+1;
        }
        return false;
    }
}
// Accepted, Solution 2
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // the 2d matrix is actually a 1d array
        int w = matrix[0].length;
        int h = matrix.length;
        int start = 0, end = w*h-1;
        while (start <= end){
            int mid = (start +end ) >> 1;
            int x = mid / w, y = mid % w;
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) end=mid-1;
            else    start=mid+1;
        }
        return false;
    }
}