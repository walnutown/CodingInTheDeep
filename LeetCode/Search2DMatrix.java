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

// Binary search to find the row that target is located,
// Then binary search to find the target
// time: O(lgm+lgn); space: O(1)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          if (matrix==null || matrix.length==0 || matrix[0].length==0)
              return false;
          int M = matrix.length, N = matrix[0].length;
          int start = 0, end = M-1;
          while (start<=end){
              int mid = start + (end-start)/2;
              if (matrix[mid][0]==target)
                  return true;
              else if (matrix[mid][0]<target)
                  start = mid+1;
              else 
                  end = mid-1;
          }
          int row = end;    // When we get out of the while loop, end < start, we should pick the smaller one
          if (end<0)    return false;   // Note here may be out of range
          start=0; end=N-1;
          while (start<=end){
              int mid = start + (end-start)/2;
              if (matrix[row][mid]==target)
                  return true;
              else if (matrix[row][mid]<target)
                 start = mid+1;
              else 
                  end = mid-1;
          }
          return false;
      }
}
// the 2d matrix can be transformed into an ordered 1d array. Transform it and then binary search the 1d array
// time: O(lg(m*n)); space: O(1)
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

