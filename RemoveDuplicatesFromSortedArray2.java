public class Solution {
    public int removeDuplicates(int[] A) {
        // same as removeDuplicatesFromSortedArray
        // add count to calculate freq
        if (A == null || A.length == 0){
            return 0;
        }
        
        if (A.length == 1){
            return 1;
        }
        
        if (A.length == 2){
            return 2;
        }
        
        int prev = A[0];
        int count = 1;
        int index = 1;
        for (int i = 1; i < A.length; i++){
            if (A[i] == prev){
                count ++;
                if (count < 3){
                A[index++] = A[i];
                }
            }  
            else{
                count = 1;
                prev = A[i];
                A[index++] = A[i];
            }
        }
        
        return index;
        
    }
}