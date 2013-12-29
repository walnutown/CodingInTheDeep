
// Runtime error, Last executed input: 1
public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return null;
        int[][] res = new int[n][n];
        recursive(res, 1, 0, n-1);
        return res;
    }
    public void recursive(int[][] res, int val, int start, int end){
        if (start < end) return;
        if (start == end){
            res[start][start] = val;
        }
        for (int i = start; i < end; i++){
            res[start][i] = val++;
        }
        for (int i = start; i < end; i++){
            res[i][end] = val++;
        }
        for (int i = end; i > start; i--){
            res[end][i] = val++;
        }
        for (int i = end ; i > start; i--){
            res[i][start] = val++;
        }
        recursive(res, val, start + 1, end -1);
    }
}


// Submission Result: Wrong Answer

// Input:  0
// Output: null
// Expected:   []
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int left = 0, right=n-1, top=0, bottom=n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while (left <= right && top <= bottom){
            for (int i=left; i<=right; i++, num++)  matrix[top][i] = num;
            if (++top > bottom) break;
            for (int i=top; i<=bottom; i++, num++)  matrix[i][right] = num;
            if (--right < left) break;
            for (int i=right; i>=left; i--, num++)  matrix[bottom][i] = num;
            if (--bottom < top) break;
            for (int i=bottom; i>=top; i--, num++)  matrix[left][i] = num;
            if (++left > right) break;
        }
        return matrix;
    }
}
// Accepted
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