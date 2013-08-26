// partial works
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length <= 2 || board[0].length <= 2){
            return;
        }
        
        int mWidth = board[0].length;
        int mHeight = board.length;
        
        int[][] flag = new int[mWidth][mHeight];
        
        for (int i = 0; i < mHeight; i++){
            if (board[i][0] == 'O'){
                flag[i][0] = 1;
            }
            if (board[i][mWidth-1] == 'O'){
                flag[i][mWidth-1] = 1;
            }
        }   
        for(int i = 0; i< mWidth; i++){
            if (board[0][i] == 'O'){
                flag[0][i] = 1;
            }
            if (board[mHeight - 1][i] == 'O'){
                flag[mHeight - 1][i] = 1;
            }
        }
        boolean[] cut = new boolean[mHeight];
        for (int i = 1; i < mWidth-1; i++){
            for (int j = 1; j < mHeight-1; j++){
                if (board[j][i] == 'O' && board[j][i-1] == 'O' && !cut[j]){
                    flag[j][i] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mHeight];
        for (int i = mWidth - 2; i > 0; i--){
            for (int j = 1; j < mHeight-1; j++){
                if (board[j][i] == 'O' && board[j][i+1] == 'O' && !cut[j]){
                    flag[j][i] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mWidth];
        for (int i = 1; i < mHeight-1; i++){
            for (int j = 1; j < mWidth-1; j++){
                if (board[i][j] == 'O' && board[i-1][j] == 'O' && !cut[j]){
                    flag[i][j] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mWidth];
        for (int i = mHeight - 2; i > 0; i--){
            for (int j = 1; j < mWidth-1; j++){
                if (board[i][j] == 'O' && board[i+1][j] == 'O' && !cut[j]){
                    flag[i][j] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        
        for (int i = 0; i < mHeight; i++){
            for(int j = 0; j < mWidth; j++){
                if (flag[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}


// BFS, TLE in large judge
public class Solution {
    int mWidth;
    int mHeight;
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length <= 2 || board[0].length <= 2){
            return;
        }
        
        mWidth = board[0].length;
        mHeight = board.length;
        
        for (int i = 0; i < mHeight; i++){
            if (board[i][0] == 'O'){  
                mark(board, i, 0);
            }
            if (board[i][mWidth-1] == 'O'){
                mark(board, i, mWidth-1);
            }
        }   
        for(int i = 0; i< mWidth; i++){
            if (board[0][i] == 'O'){
                mark(board, 0, i);
            }
            if (board[mHeight - 1][i] == 'O'){
                mark(board, mHeight-1, i);
            }
        }
        
        // flip 
        for (int i = 0; i < mHeight; i++){
            for(int j = 0; j < mWidth; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }  
        public void mark(char[][] board, int row, int col){
            Queue<Integer> qu  = new LinkedList<Integer>();
            qu.add(row * mWidth + col);
            while(qu.size() > 0){
                int curr = qu.poll();
                int x = curr/mWidth;
                int y = curr%mWidth;
                if (board[x][y] == 'O' || board[x][y] == 'N'){
                    board[x][y] = 'N';
                    BFS(board, x-1, y, qu);
                    BFS(board, x+1, y, qu);
                    BFS(board, x, y-1, qu);
                    BFS(board, x, y+1, qu);
                }
            }
        }
        
        public void BFS(char[][] board, int row, int col, Queue<Integer> qu){
            if (row < 0 || row >= mHeight || col < 0 || col >= mWidth || board[row][col] != 'O' ){
                return;
            }
            board[row][col] = 'N';
            qu.add(row * mWidth + col);
        }
}

// DFS, TLE in large judge
public class Solution {
    int mWidth;
    int mHeight;
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length <= 2 || board[0].length <= 2){
            return;
        }
        
        mWidth = board[0].length;
        mHeight = board.length;
        
        for (int i = 0; i < mHeight; i++){
            if (board[i][0] == 'O'){  
                mark(board, i, 0);
            }
            if (board[i][mWidth-1] == 'O'){
                mark(board, i, mWidth-1);
            }
        }   
        for(int i = 0; i< mWidth; i++){
            if (board[0][i] == 'O'){
                mark(board, 0, i);
            }
            if (board[mHeight - 1][i] == 'O'){
                mark(board, mHeight-1, i);
            }
        }
        
        // flip 
        for (int i = 0; i < mHeight; i++){
            for(int j = 0; j < mWidth; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }  
        public void mark(char[][] board, int row, int col){
            if (row < 0 || row >= mHeight || col < 0 || col >= mWidth || board[row][col] != 'O' ){
                return;
            }
            board[row][col] = 'N';
            mark(board, row-1, col);
            mark(board, row+1, col);
            mark(board, row, col-1);
            mark(board, row, col+1);
        }
  
}