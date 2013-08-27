public class Solution {
    
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (A == null && len == 0){
            return 0;
        }
        if (len == 1){
            return A[0];
        }
        int subStart = 0;
        int subEnd = 1;
        int disSum = 0;
        int[] mem = new int[len];
        mem[0] = A[0];
        for (int i = 1; i < len; i++){
            if (A[i] <= 0){
                disSum += A[i]; 
                mem[i] = mem[i-1];
            }
            else{
                int left = mem[i-1];
                int right = A[i];
                int both = left + disSum + right;
                mem[i] = Math.max(both, Math.max(left, right));
                if (mem[i] == left){
                    disSum += A[i];
                }
                else if (mem[i] == right){
                    subStart = i;
                    subEnd = i+1;
                    disSum = 0;
                }
                else{
                    subEnd = i +1;
                    disSum = 0;
                }
            }
        }
        
        return mem[len];  
    }  
}

