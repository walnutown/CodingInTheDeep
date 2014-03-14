/*
    Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space to hold additional elements from B. 
    The number of elements initialized in A and B are m and n respectively.
*/

// <1> compare sort from the end of array
// <2> copy remaning parts of array B to array A
// time: O(n); space: O(1)
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) return;
        int i = m-1, j = n-1;
        int index = A.length-1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j])    A[index--] = A[i--];
            else    A[index--] = B[j--];
        }
        while (j >= 0)  A[index--] = B[j--];    // don't forget this step & no need to copy remaing elements in A, understand why
    }
}