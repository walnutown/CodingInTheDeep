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