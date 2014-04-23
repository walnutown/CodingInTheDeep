/*
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
*/

// Bitset, like Hashmap, not constant space
public int firstMissingPositive(int[] A){
        int length = A.length >> 3 +1;
        BitSet s = new BitSet(length);
        for(int a: A){
            if(a > 0 && a<= length )
                s.set(a);
        }
        return s.nextClearBit(1);
}

// an interesting case is [1,1,1,1,1,1,1,1,2]
// time: O(n)
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A==null || A.length==0) return 1;       // notice return 1 here
        int i=0;
        while (i < A.length){
            // IMPORTANT conditions here, cannot miss one
            while ((A[i]-1) != i && A[i] <= A.length && A[i] > 0 && A[i] != A[A[i]-1])   swap(A, i, A[i]-1);
            i++;
        }
        for (i=0; i<A.length; i++){
            if ((A[i]-1) != i)  return i+1;
        }
        return A.length+1;
    }
    public void swap(int[] A, int i, int j){
        int tmp = A[i]; A[i]=A[j]; A[j]=tmp;
    }
}
