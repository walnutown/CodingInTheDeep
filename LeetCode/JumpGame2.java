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