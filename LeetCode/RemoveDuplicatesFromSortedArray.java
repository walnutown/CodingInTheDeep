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

// Accepted, Dec 31
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        int i=0, j=0;
        for (j=1; j<A.length; j++){
            if (A[j] == A[i])   continue;
            else    A[++i] = A[j];
        }
        return i+1;
    }
}