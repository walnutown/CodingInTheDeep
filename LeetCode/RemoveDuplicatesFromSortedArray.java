public class Solution {
    public int removeDuplicates(int[] A) {
        // use Set to count freq of the elem
        
        if (A == null){
            return 0;
        }
        if (A.length == 1){
            return 1;
        }
        
        Set<Integer> unique = new HashSet<Integer>();
        int length = 0;
        
        for(int i = 0; i < A.length; i++){
            if (!unique.contains(A[i])){
                unique.add(A[i]);
                A[length] = A[i];
                length++;
            }
        }
       
        return length;
    }
}


public class Solution {
    public int removeDuplicates(int[] A) {
         //without extra mem, using the sorted property
        
        if (A == null || A.length == 0){
            return 0;
        }
        if (A.length == 1){
            return 1;
        }
        
       
        int prev = A[0];
        int length = 1;
        
        for(int i = 1; i < A.length; i++){
            if (A[i] != prev){
                A[length] = A[i];
                length++;
                prev = A[i];
            }
        }
          
        return length;
    }
}