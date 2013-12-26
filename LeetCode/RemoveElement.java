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

// #2, two pointer here, start ,end, move end number to curr if curr = elem
public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return 0;
        int start =0;
        int end = A.length-1;
        int len = 0;
        while(start <= end){   // error: start < end
            int curr = A[start];
            if (curr == elem){
                A[start] = A[end];
                end--;
            }
            else{
                len++;
                start++;
            }
        }
        return len;
    }
}

// Accepted, Dec25
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A==null || A.length==0) return 0;
        int i=0, j=A.length-1;
        while (i <= j){
            if (A[i] == elem)   swap(A, i, j--);
            else i++;
        }
        return j+1;
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}