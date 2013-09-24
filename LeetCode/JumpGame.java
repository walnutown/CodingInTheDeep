
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