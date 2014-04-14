/*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.

    Follow up:
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

    Could you come up with an one-pass algorithm using only constant space?
*/

// Maintain 3 pointers, one for ending inedx of red -- r, one for starting index of blue -- b, and the
// third one--i, used to traverse the array
// if A[i]==2, swap to blue subarray (which is out of order), the swapped value may be 0, which may cause another swap
// So, we can't increment i
// if A[i] == 0, swap to red subarray (which has been ordered), the swapped value will not be 2. We can increment i here.
public class Solution {
    public void sortColors(int[] A) {
        if (A==null || A.length==0) return;
        int r=0, b=A.length-1, i=0;
        while (i <= b){ // at this time, b ahsn't been filled by blue yet, so we need "=" here
            if (A[i] == 0) swap(A, i++, r++); 
            else if (A[i] == 2) swap(A, i, b--); 
            else i++;
        }
    }
    public void swap(int[] A, int i, int j){
        int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
    }
}