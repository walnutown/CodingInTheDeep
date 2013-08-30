public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0){
            return 0;
        }
        
        int[] mem = new int[n+1];
        mem[1] = 1;
        mem[0] = 1;
        
        for(int i = 1; i <= n; i++){
            int len = i;
            mem[i] = 0;
            for (int j = 1; j <= len; j++){
                mem[i] += mem[j-1] * mem[len-j];
            }
        }
       
        return mem[n];
        
    }
}