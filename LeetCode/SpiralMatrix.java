// http://discuss.leetcode.com/questions/29/spiral-matrix
// iterative or recursion

// Last executed input:    []
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0)
            return res;
        int width = matrix[0].length;
        int height = matrix.length;
        int rStart = 0, rEnd = width -1;
        int cStart = 0, cEnd = height -1;
        int dir = 0;
        int i = 0, j = 0;
        while ( rStart < rEnd && cStart < cEnd){
            if (dir == 0){
                res.add(matrix[i][j]);
                i++;
                if (i == rEnd){
                    dir = 1;
                    cStart++;
                    j = cStart;
                }
            }
            else if (dir == 1){
                res.add(matrix[i][j]);
                j++;
                if (j == cEnd){
                    dir = 2;
                    rEnd--;
                    i = rEnd;
                }
            }
            else if (dir == 2){
                res.add(matrix[i][j]);
                i--;
                if (i == rStart){
                    dir = 3;
                    cEnd--;
                    j = cEnd;
                }
            }
            else if (dir == 3){
                res.add(matrix[i][j]);
                j--;
                if (j == cStart){
                    dir = 0;
                    rStart++;
                    i = rStart;
                }
            }
        }
        return res;
    }
}

// Submission Result: Runtime Error
// Last executed input:    []
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix==null)   return res;             // check matrix.length first
        int w = matrix[0].length;
        int h = matrix.length;
        if (w==0 || h==0)   return res;
        int left=0, right=w-1, top=0, bottom=h-1;
        while (left <= right && top <=bottom){
            for (int i=left; i<=right; i++)  res.add(matrix[top][i]);
            top++;
            for (int i=top; i<=bottom; i++) res.add(matrix[i][right]);
            right--;
            for (int i=right; i>=left; i--)    res.add(matrix[bottom][i]);
            bottom--;
            for (int i=bottom; i>=top; i--)   res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
// Accepted
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length==0 || matrix[0].length==0)  return res;
        int left=0, right=matrix[0].length-1, top=0, bottom= matrix.length-1;
        while (left <= right && top <=bottom){
            for (int i=left; i<=right; i++)  
                res.add(matrix[top][i]);
            if (++top > bottom) break;          // need to break immediately
            for (int i=top; i<=bottom; i++) 
                res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i=right; i>=left; i--)    
                res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i=bottom; i>=top; i--)   
                res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}