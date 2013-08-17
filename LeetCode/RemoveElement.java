public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (A == null || A.length == 0){
            return 0;
        }
        
        int len = A.length;
        int index = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] == elem){
                len--;       
            }
            else{
                A[index] = A[i];
                index++;
            }
        }
        return len;
    }
}