
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