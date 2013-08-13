public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = m + n -1;
        int i = m-1;
        int j = n-1;
        
        // pre-check
        if ( A == null || m == 0){
            while(j >= 0){
                A[j] = B[j];
                j--;
            }
            return;
        }
        
        if (B == null || n == 0){
            return;
        }
        
        // merge sort, add all values to A from its tail
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]){
                A[index] = A[i];
                index--;
                i--;
            }
            else{
                A[index] = B[j];
                index--;
                j--;
            }
        }
        
        // if i >= 0, no more operation, just leave them in A
            while(j >= 0){
                A[index] = B[j];
                index--;
                j--;
            }
        
    }
}