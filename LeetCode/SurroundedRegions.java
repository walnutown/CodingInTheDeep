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

// DFS, Runtime error
// "No, the judge is able to limit the stack space if I wanted to. For example, 
// if you use the recursive DFS approach for the problem Surrounded Regions, 
// it will result in a Runtime Error." -- 1337
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) return;
        int w = board[0].length;
        int h = board.length;
        // start from the first/last row
        for (int i = 0; i< w; i++){
            mark(board, 0, i);
            mark(board, h-1, i); 
        }
        // start from the first/last col
        for (int i = 0; i< h; i++){
            mark(board, i, 0);
            mark(board, i, w-1); 
        }
        // flip simultaneously
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'N') board[i][j] = 'O';
            }
        }
    }
   
    public void mark(char[][] board, int i, int j){
        if (board[i][j] != 'O') return;
        board[i][j] = 'N';
        if (i-1 >= 0)   mark(board, i-1, j);
        if (j-1 >= 0)   mark(board, i, j-1);
        if (i+1 < board.length)   mark(board, i+1, j);
        if (j+1 < board[0].length)   mark(board, i, j+1);
    }
}


// Accepted, BFS, Dec 26
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2){
            return;
        }
        int w = board[0].length;
        int h = board.length;
        for (int i = 0; i < h; i++){
            BFS(board, i, 0);
            BFS(board, i, w-1);
        }   
        for(int i = 0; i< w; i++){
            BFS(board, 0, i);
            BFS(board, h-1, i);
        }
        // flip 
        for (int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'N')    board[i][j] = 'O';
            }
        }
    }  
        public void BFS(char[][] board, int i, int j){
            Queue<Integer> qu  = new LinkedList<Integer>();
            mark(board, i, j, qu);
            while(!qu.isEmpty()){
                int curr = qu.poll();
                int x = curr/board[0].length;
                int y = curr%board[0].length;
                mark(board, x-1, y, qu);
                mark(board, x+1, y, qu);
                mark(board, x, y-1, qu);
                mark(board, x, y+1, qu);
            }
        }
        
        public void mark(char[][] board, int x, int y, Queue<Integer> qu){
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O' ) return;
            board[x][y] = 'N';
            qu.add(x * board[0].length + y);
        }
}