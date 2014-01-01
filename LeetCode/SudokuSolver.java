// Solution by heguang
public void solveSudoku(char[][] board){
                solveSudoku(board, 0);
        }
        private boolean solveSudoku(char[][] board, int n){         // encode the coordiantes here
                int row = n/board.length;
                int col = n%board.length;
                if(row>=board.length) return true;
                if(board[row][col]!='.') return solveSudoku(board,n+1);
                boolean[] flag = new boolean[10];
                Arrays.fill(flag, true);
                for(int i=0; i<board.length; i++){
                        if(board[row][i]!='.')
                                flag[board[row][i]-'0']=false;
                        if(board[i][col]!='.')
                                flag[board[i][col]-'0']=false;
                }
                for(int i=(row/3)*3; i< (row/3)*3+3; i++){
                        for(int j=(col/3)*3; j<(col/3)*3 + 3; j++){
                                if(board[i][j] == '.')
                                        continue;
                                flag[board[i][j]-'0']=false;
                        }
                }
                for(int i=1; i< flag.length; i++)
                        if(flag[i]){
                                board[row][col]=(char)(i+'0');
                                if(solveSudoku(board, n+1))
                                        return true;
                        }
                board[row][col]='.';
                return false;
        }


// Runtime Error
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length!=9) return;
        solver(board, 0, 0);
    }
    public void solver(char[][] board, int x, int y){
        if (x> 8){
            if(y< 8) solver(board, x, y+1);
            else return;
        }
        if (board[x][y] != '.') solver(board, x+1, y);
        else{
            Set<Integer> candidates = getCandidates(board, x, y);
            if (candidates.size()==0)   return;
            for (int candidate : candidates){
                board[x][y] = (char)(candidate + '0');
                solver(board, x+1, y);
                board[x][y] = '.';                      // WRONG! the result is cleared here
            }
        }
    }
    public Set<Integer> getCandidates(char[][] board, int x, int y){
        Set<Integer> candidates = new HashSet<Integer>();
        int[] nums = new int[10];
        for (int i=0; i<9; i++) if(board[x][i] != '.') nums[board[x][i]-'0'] = 1;
        for (int i=0; i<9; i++) if(board[i][y] != '.') nums[board[i][y]-'0'] = 1;
        int row = (x/3) * 3, col = (y/3) * 3;
        for (int i=row; i < row+3; i++){
            for (int j=col; j<col+3; j++)
                if(board[i][j] != '.') nums[board[i][j]-'0'] = 1;
        }
        for (int i=1; i<=9; i++)    if(nums[i]==0)  candidates.add(i);
        return candidates;
    }
}

// Accepted
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length!=9) return;
        solver(board, 0, 0);
    }
    public boolean solver(char[][] board, int x, int y){            // important to return boolean type here
        if (x>= board.length)   return true;
        if (y==board[0].length) return solver(board, x+1, 0);
        if (board[x][y] != '.') return solver(board, x, y+1);
        int[] nums = new int[10];
        for (int i=0; i<9; i++) {
            if(board[x][i] != '.') nums[board[x][i]-'0'] = 1;
            if(board[i][y] != '.') nums[board[i][y]-'0'] = 1;
        }
        for (int i=0; i < 3; i++){
            for (int j=0; j<3; j++){
                Character val = board[x/3*3 + i][y/3*3 + j];
                if(val != '.')  nums[val-'0'] = 1;
            }
        }
        for (int i=1; i<=9; i++){
            if(nums[i]==0){
                board[x][y] = (char)(i + '0');                      // need cast here
                if (solver(board, x, y+1))  return true;            // if the result is found in this path, just return
                board[x][y] = '.';                                  // so that the board will not be clanend again
            }
        }
        return false;
    }
}