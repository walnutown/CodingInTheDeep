// use the original array as storage, to achieve constant space
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (A == null || len == 0){
            return 1;
        }
        
        for (int i = 0; i < len; i++){
            while( A[i] != i+1){
                if (A[i] > len || A[i] <= 0 || A[i] == A[A[i]-1]){
                    break;
                }
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++){
            if (A[i] != i+1){
                return i+1;
            }
        }
        
        return len+1;
    }
}