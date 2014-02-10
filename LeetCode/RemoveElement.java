/*
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
    
// overwrite the target elem
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] != elem)   A[index++] = A[i];
        }
        return index;
    }
}

// swap target elem to the end of the array
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