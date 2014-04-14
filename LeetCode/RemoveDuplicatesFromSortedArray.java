/*
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array A = [1,1,2],

    Your function should return length = 2, and A is now [1,2].
*/

// Maintain two pointers, one for current index, and one for result index
// time: O(n); space:O(1)
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        int i=1, j=1, N =A.length;
        while (j< N){
            if (A[j] == A[j-1])
                j++;
            else
                A[i++] = A[j++];
        }
        return i;
    }
}