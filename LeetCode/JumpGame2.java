public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] mem = new int[A.length];
        for (int i = 0; i < A.length; i++){
            mem[i] = -1;
        }
        mem[0] = 0;
        for(int i = 0; i < A.length; i++){
            for (int j = i + 1; j <= A[i] + i && j < A.length ; j++){
                if (mem[j] == -1){
                    mem[j] = mem[i]+ 1;
                }
            }
        }
        
        return mem[A.length -1];
    }
}

// OJ assume that final pos can always be reached
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int step = 0;
        int currMax = 0;
        int nextMax = 0;
        for (int i = 0; i < A.length; i++){
            if (i > currMax){
                currMax = nextMax;
                step++;
            }
            nextMax = Math.max(A[i] + i, nextMax);
        }
        return step;
    }
} 

// #2 trial, DFS, TLE
public class Solution {
    int min;
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 1)
            return 0;
        min = Integer.MAX_VALUE;
        DFS(A, 0, 0);
        return min;
    }
    
    public void DFS(int[] A, int dep, int count){
        if (dep >= A.length -1){
            min = Math.min(min, count);
            return;
        }
        for (int i = 1 ; i <= A[dep]; i++)
            DFS(A, dep + A[dep], count+1);
    }
}