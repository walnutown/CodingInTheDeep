
// large judge time exceed
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1){
            return true;
        }
        
        boolean[] mem = new boolean[A.length];
        mem[0] = true;
        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (A[j] + j >= i && mem[j] == true){
                    mem[i] = true;
                }
            }
        }
        
        return mem[A.length -1 ];
        
    }
}

// pass both judge, use dis to record the furtherest dis that can reach
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1 || A == null){
            return true;
        }
        int dis = 0;
        
        for (int i = 0; i < A.length; i++){
            if (i > dis){
                return false;
            }
            if (A[i] + i > dis){
                dis = A[i] + i;
            }
            if (dis >= A.length - 1){
                return true;
            }
        }  
        return false;
    }
}
// refactor the above code
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 1)
            return true;
        int dis = 0;
        for (int i = 0; i < A.length; i++){
            if (i > dis)
                return false;
            dis = Math.max(dis, i + A[i]);
            if (dis >= A.length -1)
                return true;
        }
        return false;
    }
}


// #2 trial, create game tree, TLE.
public class Solution {
    boolean can;
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 1)
            return true;
        can = false;
        DFS(A, 0);
        return can;
    }
    
    public void DFS(int[] A, int dep){
        if (dep >= A.length-1){
            can = true;
            return;
        }
        for (int i =1; i <= A[dep]; i++){
            DFS(A, dep + A[dep]);
        }
    }
}