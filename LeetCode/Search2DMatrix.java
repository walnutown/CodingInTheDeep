/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,

    Consider the following matrix:

    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    Given target = 3, return true.
*/

// binary search both col and row. time: O(lgm+lgn)
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
// the 2d matrix is actually a 1d array, transform it and binary search, time: O(lg(m*n))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length;
        int h = matrix.length;
        int start = 0, end = w*h-1;
        while (start <= end){
            int mid = (start +end ) >> 1;
            int x = mid / w, y = mid % w;   // notice 'mid/w', what's the case of 'mid/h'?
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) end=mid-1;
            else    start=mid+1;
        }
        return false;
    }
}