/*
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
*/

// Bitset to mark the occurrence of a number
// time: O(n); space: O(n)
public int firstMissingPositive(int[] A){
        int length = A.length >> 3 +1;
        BitSet s = new BitSet(length);
        for(int a: A){
            if(a > 0 && a<= length )
                s.set(a);
        }
        return s.nextClearBit(1);
}

// Swap each element in array to its right position
// If we cannot find the corresponding element in the position, it's missing.
// time: O(n); space: O(1)
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A==null || A.length==0)
            return 1;   // if empty, return the fisrt positive 1
        int N = A.length;
        for (int i=0; i<N; i++){    // A[i]!=A[A[i]-1], otherwise, we may go into endless loop
            while (A[i]!=i+1 && A[i]-1>=0 && A[i]-1<N && A[i]!=A[A[i]-1])
                swap(A, i, A[i]-1);
        }
        for (int i=0; i<N; i++){
            if (A[i]!=i+1)  return i+1;
        }
        return N+1;
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
