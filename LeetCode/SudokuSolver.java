// Line 47: possible loss of precision
// char val = i + '0', (int i )
public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length != 9 || board[0].length != 9)
            return;
        DFS(0, 0, board);
        return;
    }
    public void DFS(int x, int y, char[][] board){
        if (x == board.length && y == board[0].length)
            return;
        if (y == board[0].length)
            DFS(x+1, 0, board);
        if (board[x][y] != '.')
            DFS(x, y+1, board);
        Set<Character> successors = findSuccessors(x, y, board);
        if (successors.size() == 0)
            return;
        for (char successor : successors){
            board[x][y] = successor;
            DFS(x, y+1, board);
            board[x][y] = '.';
        }
    }
    public Set<Character> findSuccessors(int x, int y, char[][] board){
        Set<Character> used = new HashSet<Character>();
        for (int i = 0; i < 9; i ++){
            char val = board[x][i];
            if (val != '.' && !used.contains(val))
                used.add(val);
        }
        for (int i = 0; i < 9; i++){
            char val = board[i][y];
            if (val != '.' && !used.contains(val))
                used.add(val);
        }
        for (int i = x/3 * 3; i< 3; i++){
            for (int j = y/3 * 3; i < 3; j++){  // arrayIndexOutOfBounderError
                char val = board[i][j];
                if (val != '.' && !used.contains(val))
                used.add(val);
            }
        }
        Set<Character> res = new HashSet<Character>();
        for (int i = 1; i < 10; i ++){
            char val = i + '0';
            if (!used.contains(val))
                res.add(val);
        }
        return res;
    }
}