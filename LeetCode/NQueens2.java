/*
    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
    [".Q..",  // Solution 1
    "...Q",
    "Q...",
    "..Q."],

    ["..Q.",  // Solution 2
    "Q...",
    "...Q",
    ".Q.."]
    ]
    Now, instead outputting board configurations, return the total number of distinct solutions.
*/

// DFS, use rowNum as the depth
// In each depth, we search through all columns to find valid one and do next recursive call
// time: O(n^3); space: O(n^2)
public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        int[][] board = new int[n][n];
        return finder(board, 0, n);
    }
    
    private int finder(int[][] board, int row, int n){
        if (row == n){
            return 1;
        }
        int count = 0;
        for (int i =0; i < n; i++){
            if (isValid(board, row, i)){
                board[row][i] = 1;
                count += finder(board, row+1, n);
                board[row][i] = 0;
            }
        }
        return count;
    }
    
    private boolean isValid(int[][] board, int row, int col){
        for (int i=0; i <= row; i++)
            if (board[i][col] == 1) return false;
        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)   return false;
        for (int i=row, j=col; i>=0 && j<board[0].length; i--, j++)
            if (board[i][j] == 1)   return false;
        return true;
    }
}

// DFS, use an array, easier valid check
public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        int[] num = new int[1];
        int[] rows = new int[n];
        Arrays.fill(rows, -1);
        finder(rows, 0, num);
        return num[0];
    }
    
    public void finder(int[] rows, int x, int[] num){
        if (x == rows.length){
            num[0]++;
            return;
        }
        for (int i =0; i < rows.length; i++){
            if (isValid(rows, x, i)){
                rows[x] = i;
                finder(rows, x+1, num);
                rows[x] = 0;
            }
        }
    }
    
    public boolean isValid(int[] rows, int x, int y){
        for (int i=0; i<x; i++){
            if (rows[i]==y || x-i==Math.abs(rows[i]-y)) return false;
        }
        return true;
    }
}